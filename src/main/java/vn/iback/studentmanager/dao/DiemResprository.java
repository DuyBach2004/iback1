package vn.iback.studentmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iback.studentmanager.entity.diem;
@Repository
public interface DiemResprository extends JpaRepository<diem,Integer>{
}
