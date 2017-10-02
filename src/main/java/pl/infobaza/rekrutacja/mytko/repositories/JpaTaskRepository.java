package pl.infobaza.rekrutacja.mytko.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.infobaza.rekrutacja.mytko.models.Task;

import java.util.List;

public interface JpaTaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findByCompleted(@Param("completed") Boolean completed);

}
