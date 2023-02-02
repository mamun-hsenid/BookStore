package com.bookstoreproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "authors"
)
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int userId;
    @Column(name = "author_name")
    private String userName;
    @Column(name = "author_email")
    private String userEmail;
}
