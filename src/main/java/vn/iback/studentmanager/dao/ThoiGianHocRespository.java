package vn.iback.studentmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iback.studentmanager.entity.thoiGianHoc;

import java.util.List;

public interface ThoiGianHocRespository extends JpaRepository<thoiGianHoc,Integer> {
}
