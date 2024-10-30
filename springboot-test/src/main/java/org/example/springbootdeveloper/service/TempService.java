package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.Request.PostBookRequestDto;
import org.example.springbootdeveloper.dto.Response.PostBookResponseDto;
import org.example.springbootdeveloper.entity.Temp;
import org.example.springbootdeveloper.repository.TempRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TempService {
    private final TempRepository tempRepository;

    public List<PostBookResponseDto> getAllBooks(){
        return tempRepository.findAll().stream().map(
                this::convertToResponseDto).collect(Collectors.toList());
    }

    public PostBookResponseDto getBookById(Long id){
        Temp temp= tempRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(("책을 찾을 수 없습니다.")+ id));
        return convertToResponseDto(temp);
    }

    public PostBookResponseDto createBook(PostBookRequestDto requestDto){
        Temp book= new Temp(
                null, requestDto.getTitle(),requestDto.getAuthor(),requestDto.getCategory()
        );
        Temp savedBook= tempRepository.save(book);
        return convertToResponseDto(savedBook);
    }

    // 카테고리별 책 조회
//    public List<PostBookResponseDto> getBooksByCategory(String category){
//        List<PostBookResponseDto> data= null;
//        String BookCategory= category;
//        List<Temp> temps= tempRepository.findByCategory(BookCategory);
//        data= temps.stream().map((book)->(new::Pos))
//                .collect(Collectors.toList());
//    } // 시간 부족 ㅜ

    // 전체 책 조회
    private PostBookResponseDto convertToResponseDto(Temp temp){
        return new PostBookResponseDto(
                temp.getId(), temp.getTitle(), temp.getAuthor(), temp.getCategory()
        );
    }

    public void deleteBook(Long id) {
        tempRepository.deleteById(id);
    }
}
