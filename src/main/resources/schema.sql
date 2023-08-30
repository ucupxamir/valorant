CREATE TABLE IF NOT EXISTS valorant.m_agents (
    `id` binary(16) NOT NULL,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `role` tinyint NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `Agents_chk_1` CHECK((`role` between 0 and 3))
);

CREATE TABLE IF NOT EXISTS valorant.m_maps (
    `id` binary(16) NOT NULL,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);