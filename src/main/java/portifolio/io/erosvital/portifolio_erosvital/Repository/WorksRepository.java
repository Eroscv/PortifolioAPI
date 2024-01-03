package portifolio.io.erosvital.portifolio_erosvital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import portifolio.io.erosvital.portifolio_erosvital.Domain.Works;

public interface WorksRepository extends JpaRepository <Works,Integer> {
    @Query("SELECT s FROM Works s JOIN s.partner c " +
            "WHERE UPPER(c.name) LIKE UPPER(:name) AND MONTH(s.date) = :month")
        List<Works> findBynamepartnerAndmonth(@Param("name") String name, @Param("month") Integer month);

}
