package com.amigo.app.jsonplaceholder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false)
public class Post {
    Integer userId;
    Integer id;
    String title;
    String body;
}
