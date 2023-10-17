DROP TABLE IF EXISTS file_tb;
DROP TABLE IF EXISTS crime_tb;
DROP TABLE IF EXISTS image_tb;
DROP TABLE IF EXISTS marks_tb;
DROP TABLE IF EXISTS characteristic_tb;
DROP TABLE IF EXISTS alias_tb;
DROP TABLE IF EXISTS person_tb;

-- Criação da tabela 'person_tb'

CREATE TABLE person_tb (
                           person_id BIGSERIAL PRIMARY KEY,
                           criminal_classification VARCHAR(500),
                           dt_publication VARCHAR(500),
                           person_description VARCHAR(2500),
                           title_of_publication VARCHAR(500),
                           external_id VARCHAR(500),
                           in_active  INT,
                           created_at TIMESTAMPTZ DEFAULT NOW(),
                           updated_at TIMESTAMP
);

CREATE INDEX IX01_PERSON 
ON person_tb (title_of_publication);

CREATE INDEX IX02_PERSON 
ON person_tb (external_id);

SELECT * FROM person_tb;

-- Criação da tabela 'characteristic_tb'
CREATE TABLE characteristic_tb (
                                   characteristic_id BIGSERIAL PRIMARY KEY,
                                   person_id BIGINT REFERENCES person_tb(person_id),
                                   age_range VARCHAR(500),
                                   birth_place VARCHAR(500),
                                   eye_color VARCHAR(500),
                                   ethnicity VARCHAR(500),
                                   height VARCHAR(500),
                                   weight VARCHAR(500),
                                   nationality VARCHAR(500),
                                   sex VARCHAR(500),
                                   created_at TIMESTAMPTZ DEFAULT NOW(),
                                   updated_at TIMESTAMP
);

-- Criação da tabela 'marks_tb'
CREATE TABLE marks_tb (
                          marks_id BIGSERIAL PRIMARY KEY,
                          person_id BIGINT REFERENCES person_tb(person_id),
                          marks_description VARCHAR(500),
                          created_at TIMESTAMPTZ DEFAULT NOW(),
                          updated_at TIMESTAMP
);

-- Criação da tabela 'crime_tb'
CREATE TABLE crime_tb (
                          crime_id BIGSERIAL PRIMARY KEY,
                          person_id BIGINT REFERENCES person_tb(person_id),
                          crime_description VARCHAR(500),
                          created_at TIMESTAMPTZ DEFAULT NOW(),
                          updated_at TIMESTAMP
);

-- Criação da tabela 'image_tb'
CREATE TABLE image_tb (
                          image_id BIGSERIAL PRIMARY KEY,
                          person_id BIGINT REFERENCES person_tb(person_id),
                          external_uri VARCHAR(500),
                          image_caption VARCHAR(500),
                          created_at TIMESTAMPTZ DEFAULT NOW(),
                          updated_at TIMESTAMP
);

-- Criação da tabela 'file_tb'
CREATE TABLE file_tb (
                         file_id BIGSERIAL PRIMARY KEY,
                         person_id BIGINT REFERENCES person_tb(person_id),
                         language_file VARCHAR(500),
                         external_uri VARCHAR(500),
                         created_at TIMESTAMPTZ DEFAULT NOW(),
                         updated_at TIMESTAMP
);

-- Criação da tabela 'alias_tb'
CREATE TABLE alias_tb (
                          alias_id BIGSERIAL PRIMARY KEY,
                          person_id BIGINT REFERENCES person_tb(person_id),
                          alias_description VARCHAR(500),
                          created_at TIMESTAMPTZ DEFAULT NOW(),
                          updated_at TIMESTAMP
);
