package com.wellware.smart.reposetories;

import com.wellware.smart.entities.Outgoing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutgoingRepo extends CrudRepository<Outgoing,Long> {

    List<Outgoing> findAll();
}
