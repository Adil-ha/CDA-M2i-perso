package org.example.lambok;


import lombok.*;


@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @NonNull
    private int id;


    private String lastname;

    private String firstname;
}
