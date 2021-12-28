-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'yukang', 'ykang9533@naver.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@naver.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@kakao.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@daum.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'yukang', 'martin@google.com', now(), now());

insert into publisher (`id`,`name`) values (1,'패스트캠퍼스');

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (1,'JPA 고아객체 확인 책',1, false ,100);

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (2,'토비의 Spring',1 ,false ,200);

insert into book(`id`,`name`,`publisher_id`,`deleted`,`status`) values (3,'이건 가짜 책',1,false ,200 );

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (1,'Spring 필수 책', '이건 꼭 복습도 해야지',5.0,1,2);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`) values (2,'이건 뭐지?','너무 어렵다', 2.5,1,3);

insert into comment(`id`,`comment`,`review_id`) values (1,'comment 남겨야지',1);

insert into comment(`id`,`comment`,`review_id`) values (2,'하하하하 오류',1);

insert into comment(`id`,`comment`,`review_id`) values (3,' 이건 모르겠지',2);

