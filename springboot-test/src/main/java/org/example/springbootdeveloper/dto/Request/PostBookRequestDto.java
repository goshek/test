package org.example.springbootdeveloper.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBookRequestDto {
    private String title;
    private String author;
    private String category;
}
