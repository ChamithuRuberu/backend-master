package com.AdminPanel.Admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_id", length = 10)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int BookingId;


    @Column(name = "date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "totalPrice",nullable = false)
    private Double TotalPrice;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userid;

    @OneToMany(mappedBy="booking_id")
    private Set<BookingDeails> bookingDeails;

    public Booking(Date date, Double totalPrice, User userid) {
        this.date = date;
        TotalPrice = totalPrice;
        this.userid = userid;
    }
}
