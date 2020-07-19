SET FOREIGN_KEY_CHECKS = 'OFF';

drop table if exists t_food;
create table t_food
(
    fid         int auto_increment
        primary key,
    ean         varchar(32)                        null,
    foodname    varchar(64)                        not null,
    uploader    int                                not null,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    composition int                                not null,
    constraint t_food_fid_uploader_uindex
        unique (fid, uploader),
    constraint t_food_t_composition_cid_fk
        foreign key (composition) references t_composition (cid),
    constraint t_food_t_user_uid_fk
        foreign key (uploader) references t_user (uid)
);

create index t_food_ean_uploader_index
    on t_food (ean, uploader);

create index t_food_foodname_uploader_index
    on t_food (foodname, uploader);

drop table if exists t_composition;
create table t_composition
(
    cid          int auto_increment
        primary key,
    calorie      double            not null comment 'kcal',
    protein      double default -1 null comment 'g',
    fat          double default -1 null comment 'g',
    carbohydrate double default -1 null comment 'g',
    sodium       double default -1 null comment 'mg',
    salt         double default -1 null comment 'g',
    cholesterol  double default -1 null comment 'mg',
    sugar        double default -1 null comment 'g',
    vitaminA     double default -1 null comment 'ug',
    vitaminD     double default -1 null comment 'ug',
    vitaminE     double default -1 null comment 'mg',
    vitaminK     double default -1 null comment 'ug',
    vitaminB1    double default -1 null comment 'mg',
    vitaminB2    double default -1 null comment 'mg',
    vitaminB6    double default -1 null comment 'mg',
    vitaminB12   double default -1 null comment 'ug',
    vitaminC     double default -1 null comment 'mg',
    calcium      double default -1 null comment 'mg',
    iron         double default -1 null comment 'mg',
    magnesium    double default -1 null comment 'mg',
    zinc         double default -1 null comment 'mg',
    potassium    double default -1 null comment 'mg'
)
    comment 'per 100g';

drop table if exists t_user;
create table t_user
(
    uid int auto_increment
        primary key,
    username varchar(16) not null,
    salt text not null,
    pwd text not null,
    constraint t_user_username_uindex
        unique (username)
);
create index t_user_uid_username_index
    on t_user (uid, username);

INSERT INTO karori.t_user (username, salt, pwd)
VALUES ('admin', 'b73038a4218e461fabcae6e06f82ba82',
        '5f2a544ff370e8deb03a399a4e5dee741d2919729e49a1df0aa25d8ab811052e');
INSERT INTO karori.t_user (username, salt, pwd)
VALUES ('yzz', 'd161b0d60126448794e0b1036eba7903', '619d318770b144728b93513947edff2dc27ed7f7c79d1feacb40006a9ecc655c');


drop table if exists t_log;
create table t_log
(
    lid         int auto_increment
        primary key,
    uid         int                                not null,
    fid         int                                not null,
    meal_date   datetime default CURRENT_TIMESTAMP not null,
    type        int      default 0                 not null comment '0 default, 1 breakfast, 2 lunch, 3 dinner',
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint t_log_t_food_fid_fk
        foreign key (fid) references t_food (fid),
    constraint t_log_t_user_uid_fk
        foreign key (uid) references t_user (uid)
);

create index t_log_uid_meal_date_type_index
    on t_log (uid, meal_date, type);

drop table if exists t_share;
create table t_share
(
    sid int auto_increment
        primary key,
    token varchar(64) not null,
    uid int not null,
    type int default 0 not null comment '0 all, 1 period, 2 day',
    start_date datetime null,
    end_date datetime null,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    username varchar(16) not null,
    constraint t_share_token_uindex
        unique (token),
    constraint t_share_token_uindex_2
        unique (token),
    constraint t_share_t_user_uid_username_fk
        foreign key (uid, username) references t_user (uid, username)
);

create index t_share_uid_index
    on t_share (uid);




SET FOREIGN_KEY_CHECKS = 'ON';