package pl.infobaza.rekrutacja.mytko.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.infobaza.rekrutacja.mytko.models.Task;

import java.util.List;

public interface JpaTaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findByStatus(@Param("status") Boolean status);

}
