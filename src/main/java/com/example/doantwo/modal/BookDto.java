package com.example.doantwo.modal;

import com.example.doantwo.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto extends BaseDto<BookDto> {
   private String name;
   private String Description;
   private String category;
}
