package org.example.springbootdeveloper.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String category;
}
