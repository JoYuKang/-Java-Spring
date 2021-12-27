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

