package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.Request.PostBookRequestDto;
import org.example.springbootdeveloper.dto.Response.PostBookResponseDto;
import org.example.springbootdeveloper.service.TempService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/books")
@RequiredArgsConstructor
public class TempController {
    private final TempService tempService;

    // 책 생성
    @PostMapping
    public ResponseEntity<PostBookResponseDto> createBook(@RequestBody PostBookRequestDto requestDto){
        PostBookResponseDto createBook= tempService.createBook(requestDto);

        return ResponseEntity.ok(createBook);
    }
    // 전체 책 조회
    @GetMapping
    public ResponseEntity<List<PostBookResponseDto>> getAllBooks(){
        List<PostBookResponseDto> books= tempService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 단건 책 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostBookResponseDto> getBooksById(@PathVariable Long id) {
        PostBookResponseDto book = tempService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // 특정 책 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        tempService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // 카테고리 별 책 조회
//    @GetMapping("/search/category")
//    public ResponseEntity<List<PostBookResponseDto>> getBooksByCategory(@RequestParam String category){
//        List<PostBookResponseDto> result= tempService.getBooksByCategory(category);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
}
