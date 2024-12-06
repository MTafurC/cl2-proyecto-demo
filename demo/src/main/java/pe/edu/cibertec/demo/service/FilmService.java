package pe.edu.cibertec.demo.service;

import pe.edu.cibertec.demo.dto.FilmCreateUpdateDTO;
import pe.edu.cibertec.demo.dto.FilmDetailDTO;
import pe.edu.cibertec.demo.dto.FilmListDTO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface FilmService {

    @Cacheable(value = "films")
    List<FilmListDTO> getAllFilms(); // Recuperar todas las películas para mostrar en la lista

    @Cacheable(value = "film", key = "#id")
    FilmDetailDTO getFilmById(Long id); // Consultar los detalles de una película específica por su ID

    Boolean createFilm(FilmCreateUpdateDTO filmCreateUpdateDTO); // Registrar una nueva película

    Boolean updateFilm(Long id, FilmCreateUpdateDTO filmCreateUpdateDTO); // Modificar los datos de una película existente

    Boolean deleteFilm(Long id); // Quitar una película del sistema
}
