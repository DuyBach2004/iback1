package vn.iback.studentmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iback.studentmanager.entity.binhluan;

public interface BinhluanResponsitory extends JpaRepository<binhluan,Integer> {
}
