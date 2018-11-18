package com.itheima.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "bi_result")
public class BiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "log_ymd")
    Date log_ymd;

    @Column(name = "register")
    int register;

    @Column(name = "frist_role")
    int frist_role;

    @Column(name = "day_2")
    String day_2;

    @Column(name = "day_3")
    String day_3;

    @Column(name = "day_4")
    String day_4;

    @Column(name = "day_5")
    String day_5;

    @Column(name = "day_6")
    String day_6;

    @Column(name = "day_7")
    String day_7;

    @Column(name = "day_14")
    String day_14;

    @Column(name = "day_21")
    String day_21;

    @Column(name = "day_30")
    String day_30;

    @Column(name = "day_60")
    String day_60;

    @Column(name = "day_90")
    String day_90;
}
