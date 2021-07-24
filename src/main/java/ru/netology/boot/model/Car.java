package ru.netology.boot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author bse71
 * Created on 23.07.2021
 * @since
 */
@Data
@NoArgsConstructor
public class Car {

    private int id;
    private String name;
    private String model;

}
