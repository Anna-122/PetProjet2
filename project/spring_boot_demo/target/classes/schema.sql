Use SpringBootDemo;
CREATE TABLE `cities` (
    `city_id` int NOT NULL,
    `country_id` int NOT NULL,
    `city` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `countries` (
    `country_id` int NOT NULL,
    `country` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `strains` (
    `strain_id` bigint NOT NULL,
    `strain` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `culture_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `date_time_registration` date NOT NULL,
    `country_id` bigint NOT NULL,
    `city_id` bigint NOT NULL,
    `organization_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `users` (
    `user_id` bigint NOT NULL,
    `login` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `middle_name` varchar(50) NOT NULL,
    `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `phone_number` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- Индексы таблицы `cities`
--
ALTER TABLE `cities`
    ADD PRIMARY KEY (`city_id`);

--
-- Индексы таблицы `countries`
--
ALTER TABLE `countries`
    ADD PRIMARY KEY (`country_id`);

--
-- Индексы таблицы `strains`
--
ALTER TABLE `strains`
    ADD PRIMARY KEY (`strain_id`),
    ADD UNIQUE KEY `country_id` (`country_id`),
    ADD UNIQUE KEY `city_id` (`city_id`),
    ADD UNIQUE KEY `organization_id` (`organization_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`login`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cities`
--
ALTER TABLE `cities`
    MODIFY `city_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `countries`
--
ALTER TABLE `countries`
    MODIFY `country_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `strains`
--
ALTER TABLE `strains`
    MODIFY `strain_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;
