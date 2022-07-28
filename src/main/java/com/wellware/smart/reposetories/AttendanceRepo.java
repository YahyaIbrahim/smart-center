package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends CrudRepository<Attendance,Long> {
}
