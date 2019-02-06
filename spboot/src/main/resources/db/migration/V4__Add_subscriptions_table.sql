create table user_subscription(
  chanel_id bigint not null references usr,
  subscriber_id bigint not null references usr,
  primary key (chanel_id, subscriber_id)
)