CREATE TABLE IF NOT EXISTS Article (
    id long not null primary key auto_increment,
    username varchar(255) not null,
    subject varchar(255) not null,
    content text not null,
    createDt timestamp not null default current_timestamp
)
;

CREATE TABLE IF NOT EXISTS Attachment (
    id long not null primary key auto_increment,
    articleId long not null,
    filename varchar(255) not null,
    path varchar(255) not null,
    createDt timestamp not null default current_timestamp,
    foreign key (articleId) references Article(id) on delete cascade
)
;