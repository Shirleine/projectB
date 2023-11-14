CREATE TABLE tb_address
(
    id           UUID         NOT NULL,
    street       VARCHAR(100),
    city         VARCHAR(50),
    uf           VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(8),
    country      VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(50),
    CONSTRAINT pk_tb_address PRIMARY KEY (id)
);

CREATE TABLE tb_administrators
(
    id       UUID    NOT NULL,
    email    VARCHAR(100),
    password VARCHAR(255),
    name     VARCHAR(100),
    enable   BOOLEAN NOT NULL,
    CONSTRAINT pk_tb_administrators PRIMARY KEY (id)
);

CREATE TABLE tb_bank_data
(
    id             UUID NOT NULL,
    card_number    VARCHAR(16),
    cvv            VARCHAR(3),
    validity       date NOT NULL,
    charge_address UUID NOT NULL,
    client_id      UUID,
    CONSTRAINT pk_tb_bank_data PRIMARY KEY (id)
);

CREATE TABLE tb_births
(
    id                UUID             NOT NULL,
    name              VARCHAR(100),
    date              date             NOT NULL,
    weight            DOUBLE PRECISION NOT NULL,
    length            DOUBLE PRECISION NOT NULL,
    other_information TEXT,
    CONSTRAINT pk_tb_births PRIMARY KEY (id)
);

CREATE TABLE tb_blood_donations
(
    id                UUID NOT NULL,
    date              date NOT NULL,
    institution       VARCHAR(100),
    other_information TEXT,
    health_history_id UUID,
    CONSTRAINT pk_tb_blood_donations PRIMARY KEY (id)
);

CREATE TABLE tb_charges
(
    id           UUID NOT NULL,
    cpf          VARCHAR(11),
    address_id   UUID NOT NULL,
    bank_data_id UUID NOT NULL,
    CONSTRAINT pk_tb_charges PRIMARY KEY (id)
);

CREATE TABLE tb_chats
(
    id                        UUID NOT NULL,
    social_media_professional UUID,
    partner                   UUID,
    client                    UUID,
    administrator             UUID,
    date                      date NOT NULL,
    CONSTRAINT pk_tb_chats PRIMARY KEY (id)
);

CREATE TABLE tb_children
(
    id             UUID    NOT NULL,
    name           VARCHAR(100),
    health_history UUID,
    shared         BOOLEAN NOT NULL,
    client_id      UUID,
    CONSTRAINT pk_tb_children PRIMARY KEY (id)
);

CREATE TABLE tb_clients
(
    id                UUID NOT NULL,
    cpf               VARCHAR(11),
    associated_number VARCHAR(8),
    health_history    UUID,
    preference        UUID,
    CONSTRAINT pk_tb_clients PRIMARY KEY (id)
);

CREATE TABLE tb_comments
(
    id                               UUID                        NOT NULL,
    author_social_media_professional UUID,
    author_partner                   UUID,
    author_client                    UUID,
    content                          TEXT,
    date_time                        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    publication_id                   UUID,
    CONSTRAINT pk_tb_comments PRIMARY KEY (id)
);

CREATE TABLE tb_communities
(
    id   UUID NOT NULL,
    name VARCHAR(100),
    CONSTRAINT pk_tb_communities PRIMARY KEY (id)
);

CREATE TABLE tb_communities_administrators_partners
(
    administrators_partners_id UUID NOT NULL,
    tb_communities_id          UUID NOT NULL,
    CONSTRAINT pk_tb_communities_administratorspartners PRIMARY KEY (administrators_partners_id, tb_communities_id)
);

CREATE TABLE tb_communities_administrators_social_media_professionals
(
    administrators_social_media_professionals_id UUID NOT NULL,
    tb_communities_id                            UUID NOT NULL,
    CONSTRAINT pk_tb_communities_administratorssocialmediaprofessionals PRIMARY KEY (administrators_social_media_professionals_id, tb_communities_id)
);

CREATE TABLE tb_communities_members
(
    members_id        UUID NOT NULL,
    tb_communities_id UUID NOT NULL,
    CONSTRAINT pk_tb_communities_members PRIMARY KEY (members_id, tb_communities_id)
);

CREATE TABLE tb_developments
(
    id                UUID             NOT NULL,
    date              date             NOT NULL,
    weight            DOUBLE PRECISION NOT NULL,
    height            DOUBLE PRECISION NOT NULL,
    other_information TEXT,
    pregnancy_id      UUID,
    child_id          UUID,
    CONSTRAINT pk_tb_developments PRIMARY KEY (id)
);

CREATE TABLE tb_diseases
(
    id                UUID NOT NULL,
    name              VARCHAR(100),
    diagnosis         TEXT,
    disease_type      VARCHAR(255),
    health_history_id UUID,
    CONSTRAINT pk_tb_diseases PRIMARY KEY (id)
);

CREATE TABLE tb_events
(
    id         UUID                        NOT NULL,
    name       VARCHAR(100),
    date_time  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    place      VARCHAR(100),
    event_type VARCHAR(255)                NOT NULL,
    shared     BOOLEAN                     NOT NULL,
    CONSTRAINT pk_tb_events PRIMARY KEY (id)
);

CREATE TABLE tb_exams
(
    id                UUID    NOT NULL,
    institution       VARCHAR(100),
    name              VARCHAR(100),
    result            TEXT,
    reference_value   VARCHAR(25),
    date              date    NOT NULL,
    description       TEXT,
    shared            BOOLEAN NOT NULL,
    disease_id        UUID,
    health_history_id UUID,
    pregnancy_id      UUID,
    CONSTRAINT pk_tb_exams PRIMARY KEY (id)
);

CREATE TABLE tb_exams_files
(
    files_id    UUID NOT NULL,
    tb_exams_id UUID NOT NULL
);

CREATE TABLE tb_files
(
    id        UUID         NOT NULL,
    name      VARCHAR(25),
    file_type VARCHAR(255) NOT NULL,
    files     UUID,
    CONSTRAINT pk_tb_files PRIMARY KEY (id)
);

CREATE TABLE tb_health_histories
(
    id     UUID    NOT NULL,
    shared BOOLEAN NOT NULL,
    CONSTRAINT pk_tb_health_histories PRIMARY KEY (id)
);

CREATE TABLE tb_health_insurances
(
    id               UUID NOT NULL,
    company          VARCHAR(100),
    medical_coverage VARCHAR(255),
    policy           VARCHAR(25),
    start_date       date NOT NULL,
    end_date         date NOT NULL,
    client_id        UUID,
    CONSTRAINT pk_tb_health_insurances PRIMARY KEY (id)
);

CREATE TABLE tb_health_professionals
(
    id           UUID NOT NULL,
    name         VARCHAR(100),
    records      VARCHAR(8),
    disease_id   UUID,
    exam_id      UUID,
    surgery_id   UUID,
    query_id     UUID,
    treatment_id UUID,
    CONSTRAINT pk_tb_health_professionals PRIMARY KEY (id)
);

CREATE TABLE tb_items
(
    id       UUID             NOT NULL,
    quantity INTEGER          NOT NULL,
    total    DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_tb_items PRIMARY KEY (id)
);

CREATE TABLE tb_menstrual_cycles
(
    id         UUID NOT NULL,
    start_date date NOT NULL,
    end_date   date NOT NULL,
    client_id  UUID,
    CONSTRAINT pk_tb_menstrual_cycles PRIMARY KEY (id)
);

CREATE TABLE tb_menstrual_cycles_symptoms_of_moods
(
    symptoms_of_moods_id   UUID NOT NULL,
    tb_menstrual_cycles_id UUID NOT NULL,
    CONSTRAINT pk_tb_menstrual_cycles_symptomsofmoods PRIMARY KEY (symptoms_of_moods_id, tb_menstrual_cycles_id)
);

CREATE TABLE tb_messages
(
    id                               UUID NOT NULL,
    sender_client                    UUID,
    sender_partner                   UUID,
    sender_social_media_professional UUID,
    sender_administrator             UUID,
    content                          TEXT,
    chat_id                          UUID,
    CONSTRAINT pk_tb_messages PRIMARY KEY (id)
);

CREATE TABLE tb_messages_files
(
    files_id       UUID NOT NULL,
    tb_messages_id UUID NOT NULL
);

CREATE TABLE tb_partners
(
    id           UUID         NOT NULL,
    name         VARCHAR(100),
    email        VARCHAR(100),
    password     VARCHAR(255),
    phone        VARCHAR(11)  NOT NULL,
    cnpj         VARCHAR(14),
    approval     VARCHAR(255) NOT NULL,
    address      UUID         NOT NULL,
    partner_type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tb_partners PRIMARY KEY (id)
);

CREATE TABLE tb_partners_followers
(
    followers_id   UUID NOT NULL,
    tb_partners_id UUID NOT NULL,
    CONSTRAINT pk_tb_partners_followers PRIMARY KEY (followers_id, tb_partners_id)
);

CREATE TABLE tb_preferences
(
    id            UUID NOT NULL,
    measured_unit VARCHAR(255),
    language      VARCHAR(255),
    date_format   VARCHAR(10),
    CONSTRAINT pk_tb_preferences PRIMARY KEY (id)
);

CREATE TABLE tb_pregnancies
(
    id                UUID    NOT NULL,
    shared            BOOLEAN NOT NULL,
    health_history_id UUID,
    CONSTRAINT pk_tb_pregnancies PRIMARY KEY (id)
);

CREATE TABLE tb_products
(
    id      UUID             NOT NULL,
    name    VARCHAR(100),
    value   DOUBLE PRECISION NOT NULL,
    item_id UUID,
    CONSTRAINT pk_tb_products PRIMARY KEY (id)
);

CREATE TABLE tb_publications
(
    id                               UUID    NOT NULL,
    description                      TEXT,
    author_social_media_professional UUID,
    author_partner                   UUID,
    date                             date    NOT NULL,
    approval                         BOOLEAN NOT NULL,
    community_id                     UUID,
    social_media_professional_id     UUID,
    partner                          UUID,
    CONSTRAINT pk_tb_publications PRIMARY KEY (id)
);

CREATE TABLE tb_publications_files
(
    files_id           UUID NOT NULL,
    tb_publications_id UUID NOT NULL
);

CREATE TABLE tb_publications_likes
(
    likes_id           UUID NOT NULL,
    tb_publications_id UUID NOT NULL,
    CONSTRAINT pk_tb_publications_likes PRIMARY KEY (likes_id, tb_publications_id)
);

CREATE TABLE tb_queries
(
    id                UUID NOT NULL,
    date              date NOT NULL,
    health_history_id UUID,
    pregnancy_id      UUID,
    CONSTRAINT pk_tb_queries PRIMARY KEY (id)
);

CREATE TABLE tb_queries_files
(
    files_id      UUID NOT NULL,
    tb_queries_id UUID NOT NULL
);

CREATE TABLE tb_reminders
(
    id       UUID                   NOT NULL,
    medicine VARCHAR(100),
    time     time WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_tb_reminders PRIMARY KEY (id)
);

CREATE TABLE tb_shopping
(
    id        UUID NOT NULL,
    client_id UUID,
    CONSTRAINT pk_tb_shopping PRIMARY KEY (id)
);

CREATE TABLE tb_shopping_items
(
    items_id       UUID NOT NULL,
    tb_shopping_id UUID NOT NULL
);

CREATE TABLE tb_social_media_professionals
(
    id                UUID         NOT NULL,
    name              VARCHAR(100),
    birth_date        date         NOT NULL,
    phone             VARCHAR(11)  NOT NULL,
    gender            VARCHAR(255) NOT NULL,
    email             VARCHAR(100),
    password          VARCHAR(255),
    approval          VARCHAR(255) NOT NULL,
    address           UUID         NOT NULL,
    records           VARCHAR(8),
    professional_type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tb_social_media_professionals PRIMARY KEY (id)
);

CREATE TABLE tb_social_media_professionals_followers
(
    followers_id                     UUID NOT NULL,
    tb_social_media_professionals_id UUID NOT NULL,
    CONSTRAINT pk_tb_social_media_professionals_followers PRIMARY KEY (followers_id, tb_social_media_professionals_id)
);

CREATE TABLE tb_surgeries
(
    id                UUID NOT NULL,
    date              date NOT NULL,
    surgery_type      VARCHAR(255),
    body_place        VARCHAR(100),
    institution       VARCHAR(100),
    health_history_id UUID,
    CONSTRAINT pk_tb_surgeries PRIMARY KEY (id)
);

CREATE TABLE tb_symptoms
(
    tb_diseases_id UUID NOT NULL,
    symptoms       VARCHAR(255)
);

CREATE TABLE tb_symptoms_and_moods
(
    id                UUID    NOT NULL,
    colic             BOOLEAN NOT NULL,
    mood_changes      BOOLEAN NOT NULL,
    other_discomforts BOOLEAN NOT NULL,
    CONSTRAINT pk_tb_symptoms_and_moods PRIMARY KEY (id)
);

CREATE TABLE tb_times
(
    id        UUID                   NOT NULL,
    time      time WITHOUT TIME ZONE NOT NULL,
    type_time VARCHAR(255)           NOT NULL,
    client_id UUID,
    CONSTRAINT pk_tb_times PRIMARY KEY (id)
);

CREATE TABLE tb_treatments
(
    id                UUID         NOT NULL,
    treatment_type    VARCHAR(255) NOT NULL,
    date              date         NOT NULL,
    other_information TEXT,
    health_history_id UUID,
    disease_id        UUID,
    CONSTRAINT pk_tb_treatments PRIMARY KEY (id)
);

CREATE TABLE tb_vaccines
(
    id                UUID NOT NULL,
    name              VARCHAR(100),
    date              date NOT NULL,
    body_place        VARCHAR(100),
    institution       VARCHAR(100),
    health_history_id UUID,
    CONSTRAINT pk_tb_vaccines PRIMARY KEY (id)
);

ALTER TABLE tb_exams_files
    ADD CONSTRAINT uc_tb_exams_files_files UNIQUE (files_id);

ALTER TABLE tb_menstrual_cycles_symptoms_of_moods
    ADD CONSTRAINT uc_tb_menstrual_cycles_symptoms_of_moods_symptomsofmoods UNIQUE (symptoms_of_moods_id);

ALTER TABLE tb_messages_files
    ADD CONSTRAINT uc_tb_messages_files_files UNIQUE (files_id);

ALTER TABLE tb_publications_files
    ADD CONSTRAINT uc_tb_publications_files_files UNIQUE (files_id);

ALTER TABLE tb_publications_likes
    ADD CONSTRAINT uc_tb_publications_likes_likes UNIQUE (likes_id);

ALTER TABLE tb_queries_files
    ADD CONSTRAINT uc_tb_queries_files_files UNIQUE (files_id);

ALTER TABLE tb_bank_data
    ADD CONSTRAINT FK_TB_BANK_DATA_ON_CHARGE_ADDRESS FOREIGN KEY (charge_address) REFERENCES tb_address (id);

ALTER TABLE tb_bank_data
    ADD CONSTRAINT FK_TB_BANK_DATA_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_blood_donations
    ADD CONSTRAINT FK_TB_BLOOD_DONATIONS_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_charges
    ADD CONSTRAINT FK_TB_CHARGES_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES tb_address (id);

ALTER TABLE tb_charges
    ADD CONSTRAINT FK_TB_CHARGES_ON_BANKDATA FOREIGN KEY (bank_data_id) REFERENCES tb_bank_data (id);

ALTER TABLE tb_chats
    ADD CONSTRAINT FK_TB_CHATS_ON_ADMINISTRATOR FOREIGN KEY (administrator) REFERENCES tb_administrators (id);

ALTER TABLE tb_chats
    ADD CONSTRAINT FK_TB_CHATS_ON_CLIENT FOREIGN KEY (client) REFERENCES tb_clients (id);

ALTER TABLE tb_chats
    ADD CONSTRAINT FK_TB_CHATS_ON_PARTNER FOREIGN KEY (partner) REFERENCES tb_partners (id);

ALTER TABLE tb_chats
    ADD CONSTRAINT FK_TB_CHATS_ON_SOCIAL_MEDIA_PROFESSIONAL FOREIGN KEY (social_media_professional) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_children
    ADD CONSTRAINT FK_TB_CHILDREN_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_children
    ADD CONSTRAINT FK_TB_CHILDREN_ON_HEALTH_HISTORY FOREIGN KEY (health_history) REFERENCES tb_health_histories (id);

ALTER TABLE tb_clients
    ADD CONSTRAINT FK_TB_CLIENTS_ON_HEALTH_HISTORY FOREIGN KEY (health_history) REFERENCES tb_health_histories (id);

ALTER TABLE tb_clients
    ADD CONSTRAINT FK_TB_CLIENTS_ON_PREFERENCE FOREIGN KEY (preference) REFERENCES tb_preferences (id);

ALTER TABLE tb_comments
    ADD CONSTRAINT FK_TB_COMMENTS_ON_AUTHOR_CLIENT FOREIGN KEY (author_client) REFERENCES tb_clients (id);

ALTER TABLE tb_comments
    ADD CONSTRAINT FK_TB_COMMENTS_ON_AUTHOR_PARTNER FOREIGN KEY (author_partner) REFERENCES tb_partners (id);

ALTER TABLE tb_comments
    ADD CONSTRAINT FK_TB_COMMENTS_ON_AUTHOR_SOCIAL_MEDIA_PROFESSIONAL FOREIGN KEY (author_social_media_professional) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_comments
    ADD CONSTRAINT FK_TB_COMMENTS_ON_PUBLICATION FOREIGN KEY (publication_id) REFERENCES tb_publications (id);

ALTER TABLE tb_developments
    ADD CONSTRAINT FK_TB_DEVELOPMENTS_ON_CHILD FOREIGN KEY (child_id) REFERENCES tb_children (id);

ALTER TABLE tb_developments
    ADD CONSTRAINT FK_TB_DEVELOPMENTS_ON_PREGNANCY FOREIGN KEY (pregnancy_id) REFERENCES tb_pregnancies (id);

ALTER TABLE tb_diseases
    ADD CONSTRAINT FK_TB_DISEASES_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_exams
    ADD CONSTRAINT FK_TB_EXAMS_ON_DISEASE FOREIGN KEY (disease_id) REFERENCES tb_diseases (id);

ALTER TABLE tb_exams
    ADD CONSTRAINT FK_TB_EXAMS_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_exams
    ADD CONSTRAINT FK_TB_EXAMS_ON_PREGNANCY FOREIGN KEY (pregnancy_id) REFERENCES tb_pregnancies (id);

ALTER TABLE tb_files
    ADD CONSTRAINT FK_TB_FILES_ON_FILES FOREIGN KEY (files) REFERENCES tb_queries (id);

ALTER TABLE tb_files
    ADD CONSTRAINT FK_TB_FILES_ON_FILES6fB4vg FOREIGN KEY (files) REFERENCES tb_messages (id);

ALTER TABLE tb_files
    ADD CONSTRAINT FK_TB_FILES_ON_FILESOSZcWD FOREIGN KEY (files) REFERENCES tb_publications (id);

ALTER TABLE tb_health_insurances
    ADD CONSTRAINT FK_TB_HEALTH_INSURANCES_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_health_professionals
    ADD CONSTRAINT FK_TB_HEALTH_PROFESSIONALS_ON_DISEASE FOREIGN KEY (disease_id) REFERENCES tb_diseases (id);

ALTER TABLE tb_health_professionals
    ADD CONSTRAINT FK_TB_HEALTH_PROFESSIONALS_ON_EXAM FOREIGN KEY (exam_id) REFERENCES tb_exams (id);

ALTER TABLE tb_health_professionals
    ADD CONSTRAINT FK_TB_HEALTH_PROFESSIONALS_ON_QUERY FOREIGN KEY (query_id) REFERENCES tb_queries (id);

ALTER TABLE tb_health_professionals
    ADD CONSTRAINT FK_TB_HEALTH_PROFESSIONALS_ON_SURGERY FOREIGN KEY (surgery_id) REFERENCES tb_surgeries (id);

ALTER TABLE tb_health_professionals
    ADD CONSTRAINT FK_TB_HEALTH_PROFESSIONALS_ON_TREATMENT FOREIGN KEY (treatment_id) REFERENCES tb_treatments (id);

ALTER TABLE tb_menstrual_cycles
    ADD CONSTRAINT FK_TB_MENSTRUAL_CYCLES_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_messages
    ADD CONSTRAINT FK_TB_MESSAGES_ON_CHAT FOREIGN KEY (chat_id) REFERENCES tb_chats (id);

ALTER TABLE tb_messages
    ADD CONSTRAINT FK_TB_MESSAGES_ON_SENDER_ADMINISTRATOR FOREIGN KEY (sender_administrator) REFERENCES tb_administrators (id);

ALTER TABLE tb_messages
    ADD CONSTRAINT FK_TB_MESSAGES_ON_SENDER_CLIENT FOREIGN KEY (sender_client) REFERENCES tb_clients (id);

ALTER TABLE tb_messages
    ADD CONSTRAINT FK_TB_MESSAGES_ON_SENDER_PARTNER FOREIGN KEY (sender_partner) REFERENCES tb_partners (id);

ALTER TABLE tb_messages
    ADD CONSTRAINT FK_TB_MESSAGES_ON_SENDER_SOCIAL_MEDIA_PROFESSIONAL FOREIGN KEY (sender_social_media_professional) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_partners
    ADD CONSTRAINT FK_TB_PARTNERS_ON_ADDRESS FOREIGN KEY (address) REFERENCES tb_address (id);

ALTER TABLE tb_pregnancies
    ADD CONSTRAINT FK_TB_PREGNANCIES_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_products
    ADD CONSTRAINT FK_TB_PRODUCTS_ON_ITEM FOREIGN KEY (item_id) REFERENCES tb_items (id);

ALTER TABLE tb_publications
    ADD CONSTRAINT FK_TB_PUBLICATIONS_ON_AUTHOR_PARTNER FOREIGN KEY (author_partner) REFERENCES tb_partners (id);

ALTER TABLE tb_publications
    ADD CONSTRAINT FK_TB_PUBLICATIONS_ON_AUTHOR_SOCIAL_MEDIA_PROFESSIONAL FOREIGN KEY (author_social_media_professional) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_publications
    ADD CONSTRAINT FK_TB_PUBLICATIONS_ON_COMMUNITY FOREIGN KEY (community_id) REFERENCES tb_communities (id);

ALTER TABLE tb_publications
    ADD CONSTRAINT FK_TB_PUBLICATIONS_ON_PARTNER FOREIGN KEY (partner) REFERENCES tb_partners (id);

ALTER TABLE tb_publications
    ADD CONSTRAINT FK_TB_PUBLICATIONS_ON_SOCIAL_MEDIA_PROFESSIONAL FOREIGN KEY (social_media_professional_id) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_queries
    ADD CONSTRAINT FK_TB_QUERIES_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_queries
    ADD CONSTRAINT FK_TB_QUERIES_ON_PREGNANCY FOREIGN KEY (pregnancy_id) REFERENCES tb_pregnancies (id);

ALTER TABLE tb_shopping
    ADD CONSTRAINT FK_TB_SHOPPING_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_social_media_professionals
    ADD CONSTRAINT FK_TB_SOCIAL_MEDIA_PROFESSIONALS_ON_ADDRESS FOREIGN KEY (address) REFERENCES tb_address (id);

ALTER TABLE tb_surgeries
    ADD CONSTRAINT FK_TB_SURGERIES_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_times
    ADD CONSTRAINT FK_TB_TIMES_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_clients (id);

ALTER TABLE tb_treatments
    ADD CONSTRAINT FK_TB_TREATMENTS_ON_DISEASE FOREIGN KEY (disease_id) REFERENCES tb_diseases (id);

ALTER TABLE tb_treatments
    ADD CONSTRAINT FK_TB_TREATMENTS_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_vaccines
    ADD CONSTRAINT FK_TB_VACCINES_ON_HEALTH_HISTORY FOREIGN KEY (health_history_id) REFERENCES tb_health_histories (id);

ALTER TABLE tb_symptoms
    ADD CONSTRAINT fk_tb_symptoms_on_disease FOREIGN KEY (tb_diseases_id) REFERENCES tb_diseases (id);

ALTER TABLE tb_communities_administrators_partners
    ADD CONSTRAINT fk_tbcomadmpar_on_community FOREIGN KEY (tb_communities_id) REFERENCES tb_communities (id);

ALTER TABLE tb_communities_administrators_partners
    ADD CONSTRAINT fk_tbcomadmpar_on_partner FOREIGN KEY (administrators_partners_id) REFERENCES tb_partners (id);

ALTER TABLE tb_communities_administrators_social_media_professionals
    ADD CONSTRAINT fk_tbcomadmsocmedpro_on_community FOREIGN KEY (tb_communities_id) REFERENCES tb_communities (id);

ALTER TABLE tb_communities_administrators_social_media_professionals
    ADD CONSTRAINT fk_tbcomadmsocmedpro_on_social_media_professional FOREIGN KEY (administrators_social_media_professionals_id) REFERENCES tb_social_media_professionals (id);

ALTER TABLE tb_communities_members
    ADD CONSTRAINT fk_tbcommem_on_client FOREIGN KEY (members_id) REFERENCES tb_clients (id);

ALTER TABLE tb_communities_members
    ADD CONSTRAINT fk_tbcommem_on_community FOREIGN KEY (tb_communities_id) REFERENCES tb_communities (id);

ALTER TABLE tb_exams_files
    ADD CONSTRAINT fk_tbexafil_on_exam FOREIGN KEY (tb_exams_id) REFERENCES tb_exams (id);

ALTER TABLE tb_exams_files
    ADD CONSTRAINT fk_tbexafil_on_file FOREIGN KEY (files_id) REFERENCES tb_files (id);

ALTER TABLE tb_menstrual_cycles_symptoms_of_moods
    ADD CONSTRAINT fk_tbmencycsymofmoo_on_menstrual_cycle FOREIGN KEY (tb_menstrual_cycles_id) REFERENCES tb_menstrual_cycles (id);

ALTER TABLE tb_menstrual_cycles_symptoms_of_moods
    ADD CONSTRAINT fk_tbmencycsymofmoo_on_symptoms_and_mood FOREIGN KEY (symptoms_of_moods_id) REFERENCES tb_symptoms_and_moods (id);

ALTER TABLE tb_messages_files
    ADD CONSTRAINT fk_tbmesfil_on_file FOREIGN KEY (files_id) REFERENCES tb_files (id);

ALTER TABLE tb_messages_files
    ADD CONSTRAINT fk_tbmesfil_on_message FOREIGN KEY (tb_messages_id) REFERENCES tb_messages (id);

ALTER TABLE tb_partners_followers
    ADD CONSTRAINT fk_tbparfol_on_client FOREIGN KEY (followers_id) REFERENCES tb_clients (id);

ALTER TABLE tb_partners_followers
    ADD CONSTRAINT fk_tbparfol_on_partner FOREIGN KEY (tb_partners_id) REFERENCES tb_partners (id);

ALTER TABLE tb_publications_files
    ADD CONSTRAINT fk_tbpubfil_on_file FOREIGN KEY (files_id) REFERENCES tb_files (id);

ALTER TABLE tb_publications_files
    ADD CONSTRAINT fk_tbpubfil_on_publication FOREIGN KEY (tb_publications_id) REFERENCES tb_publications (id);

ALTER TABLE tb_publications_likes
    ADD CONSTRAINT fk_tbpublik_on_client FOREIGN KEY (likes_id) REFERENCES tb_clients (id);

ALTER TABLE tb_publications_likes
    ADD CONSTRAINT fk_tbpublik_on_publication FOREIGN KEY (tb_publications_id) REFERENCES tb_publications (id);

ALTER TABLE tb_queries_files
    ADD CONSTRAINT fk_tbquefil_on_file FOREIGN KEY (files_id) REFERENCES tb_files (id);

ALTER TABLE tb_queries_files
    ADD CONSTRAINT fk_tbquefil_on_query FOREIGN KEY (tb_queries_id) REFERENCES tb_queries (id);

ALTER TABLE tb_shopping_items
    ADD CONSTRAINT fk_tbshoite_on_item FOREIGN KEY (items_id) REFERENCES tb_items (id);

ALTER TABLE tb_shopping_items
    ADD CONSTRAINT fk_tbshoite_on_shopping FOREIGN KEY (tb_shopping_id) REFERENCES tb_shopping (id);

ALTER TABLE tb_social_media_professionals_followers
    ADD CONSTRAINT fk_tbsocmedprofol_on_client FOREIGN KEY (followers_id) REFERENCES tb_clients (id);

ALTER TABLE tb_social_media_professionals_followers
    ADD CONSTRAINT fk_tbsocmedprofol_on_social_media_professional FOREIGN KEY (tb_social_media_professionals_id) REFERENCES tb_social_media_professionals (id);