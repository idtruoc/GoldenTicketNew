package com.example.goldenticketnew.model;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.audit.UserDateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Data
@Entity
@Table(name = "article")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Article extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "title")
    private String title;
    @Column(name = "brief")
    private String brief;
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "image1")
    private String image1;
    @Column(name = "status")
    private ArticleStatus status;
    @Column(name = "type")
    private ArticleType type;

    private String keyword;

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id")
    private Category category;

}
