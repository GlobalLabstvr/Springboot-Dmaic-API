package com.glabs.dmaic.dmaic_app;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DmaicRepository extends JpaRepository<Dmaic, Long> 
{
	//List<Dmaic> findByUserId(Long userId);
}
