package com.picafe.team_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "feedback_id", nullable = false)
        private int feedbackId;

        @Column(name = "order_id", nullable = false)
        private int orderId;

        @Column(name = "quality_rating", nullable = false)
        private int qualityRating;

        @Column(name = "service_rating", nullable = false)
        private int serviceRating;

    }
