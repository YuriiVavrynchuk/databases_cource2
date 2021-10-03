INSERT INTO `animators_orders`.`country` (`country`) VALUES ('Uganda');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('CumBodga');

INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('TSUKAT', 'Bandera', '1000000', 'MIT', '911', '1');

INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Yura', 'Vavryk', '100', 'Male', 'Luntik', '10000', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('1', '1');

INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Yura', 'Vavryk', '100', 'Male', '02', 'veres', '1000', '0', '1', '1');

INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`) VALUES ('Donbass', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22');

INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:22', 'Yura', '1000', '100', 'Pop', '1', '1', '1');

INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Yura', '2008-10-23 10:37:22', '100', '100', '1000', 'Yura', '1');

INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('1', '1');

INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Yurii', '2008-10-23 10:37:22', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '1', '1');
