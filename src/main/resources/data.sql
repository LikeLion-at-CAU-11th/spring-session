INSERT INTO member (name, nickname, is_deleted, deleted_at) VALUES
    ('DummyName1', 'DummyNickname1', false, NULL),
    ('DummyName2', 'DummyNickname2', false, NULL),
    ('DummyName3', 'DummyNickname3', false, NULL);

INSERT INTO letter_box (name, letter_limit, code, member_id) VALUES
    ('DummyBoxName', 20, 'DummyCode', 1);


INSERT INTO letter (title, content, box_id) VALUES
    ('편지 제목 1', 'DummyContent1', 1),
    ('편지 제목 2', 'DummyContent2', 1),
    ('편제 제목 3', 'DummyContent3', 1);
