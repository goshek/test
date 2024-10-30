package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempRepository extends JpaRepository<Temp, Long> {
    // 제목으로 찾기
    List<Temp> findByTitleContaining(String keyword);

    // 작가명으로 찾기
    List<Temp> findByAuthor(String author);

    // 특정 카테고리로 찾기
    List<Temp> findByCategory(String category);
}
