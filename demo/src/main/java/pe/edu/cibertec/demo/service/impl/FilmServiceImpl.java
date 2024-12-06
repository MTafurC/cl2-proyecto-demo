package pe.edu.cibertec.demo.service.impl;


import pe.edu.cibertec.demo.dto.FilmCreateUpdateDTO;
import pe.edu.cibertec.demo.dto.FilmDetailDTO;
import pe.edu.cibertec.demo.dto.FilmListDTO;
import pe.edu.cibertec.demo.model.Film;
import pe.edu.cibertec.demo.model.Language;
import pe.edu.cibertec.demo.model.Category;
import pe.edu.cibertec.demo.repository.FilmRepository;
import pe.edu.cibertec.demo.repository.LanguageRepository;
import pe.edu.cibertec.demo.repository.CategoryRepository;
import pe.edu.cibertec.demo.service.FilmService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    @Cacheable("films")
    public List<FilmListDTO> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(film -> new FilmListDTO(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(), // Incluye la descripción
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate()))
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "film", key = "#id")
    public FilmDetailDTO getFilmById(Long id) {
        return filmRepository.findById(id)
                .map(film -> new FilmDetailDTO(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getCategories().stream()
                                .map(Category::getCategoryId)
                                .collect(Collectors.toList()),
                        film.getCategories().stream()
                                .map(Category::getName)
                                .collect(Collectors.joining(", "))
                )).orElse(null);
    }


    @Override
    @CacheEvict(value = {"films", "film"}, allEntries = true)
    public Boolean createFilm(FilmCreateUpdateDTO filmCreateUpdateDTO) {
        Film film = mapDtoToEntity(filmCreateUpdateDTO, new Film());
        filmRepository.save(film);
        return true;
    }


    @Override
    @CacheEvict(value = {"films", "film"}, allEntries = true)
    public Boolean updateFilm(Long id, FilmCreateUpdateDTO filmCreateUpdateDTO) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with ID: " + id));
        film = mapDtoToEntity(filmCreateUpdateDTO, film);
        filmRepository.save(film);
        return true;
    }


    @Transactional
    @Override
    @CacheEvict(value = {"films", "film"}, allEntries = true)
    public Boolean deleteFilm(Long filmId) {
        // Buscar la película
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException("Film not found"));


        film.getFilmCategories().clear();
        film.getFilmActors().clear();
        film.getInventories().clear();


        filmRepository.save(film);


        entityManager.unwrap(Session.class).flush();
        entityManager.unwrap(Session.class).clear();

        filmRepository.deleteById(filmId);

        return true;
    }


    private Film mapDtoToEntity(FilmCreateUpdateDTO dto, Film film) {
        // Mapeo de campos básicos
        film.setTitle(dto.getTitle());
        film.setDescription(dto.getDescription());
        film.setReleaseYear(dto.getReleaseYear());
        film.setRentalDuration(dto.getRentalDuration());
        film.setRentalRate(dto.getRentalRate());
        film.setLength(dto.getLength());
        film.setReplacementCost(dto.getReplacementCost());
        film.setRating(dto.getRating());
        film.setSpecialFeatures(dto.getSpecialFeatures());


        Language language = languageRepository.findById(dto.getLanguageId())
                .orElseThrow(() -> new RuntimeException("Language not found with ID: " + dto.getLanguageId()));
        film.setLanguage(language);


        if (dto.getCategoryIds() != null && !dto.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepository.findAllById(dto.getCategoryIds());
            if (categories.size() != dto.getCategoryIds().size()) {
                throw new RuntimeException("Some categories were not found");
            }
            film.setCategories(categories);
        } else {
            film.setCategories(List.of());
        }

        return film;
    }
}
