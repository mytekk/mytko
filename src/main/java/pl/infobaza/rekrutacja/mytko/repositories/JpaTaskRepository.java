package pl.infobaza.rekrutacja.mytko.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.infobaza.rekrutacja.mytko.models.Task;

public interface JpaTaskRepository extends PagingAndSortingRepository<Task, Long> {
}
