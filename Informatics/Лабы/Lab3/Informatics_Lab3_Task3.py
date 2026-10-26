# Author = Bolshakov Vladislav Sergeevich
# Group = P3115
# Date = 26.10.2026

import re

WORD = re.compile(r"(\b[А-Яа-яЁё]+\b)")

ENDING = re.compile(
    r"(ыми|ими|ого|его|ому|ему|ую|юю|ая|яя|ое|ее|ые|ие|ых|их|ым|им|ом|ем|ой|ей|ый|ий)$",
    re.IGNORECASE
)


def get_adjective_stem(word):
    word = word.lower()
    match = ENDING.search(word)

    if match is None:
        return None

    return word[:match.start()]


def replace_adjective_forms(text, number):
    if number < 1:
        raise ValueError("Номер должен быть положительным.")

    # находим все слова в тексте
    words = WORD.findall(text)

    # для каждого слова находим его основу
    stems = []

    for word in words:
        stem = get_adjective_stem(word)
        stems.append(stem)

    # находим позиции слов, основы которых повторяются
    candidates = []

    for i, stem in enumerate(stems):
        if stem is not None and stems.count(stem) > 1:
            candidates.append(i)

    if number > len(candidates):
        raise ValueError("Такого номера нет.")

    # выбираем нужное слово, его основу и форму для замены
    selected_index = candidates[number - 1]
    selected_stem = stems[selected_index]
    replacement = words[selected_index].lower()

    # разделяем текст на слова и промежутки между ними
    parts = WORD.split(text)
    word_index = 0

    # заменяем слова с выбранной основой
    for i in range(1, len(parts), 2):
        word = parts[i]

        if stems[word_index] == selected_stem:
            if word[0].isupper():
                parts[i] = replacement.capitalize()
            else:
                parts[i] = replacement

        word_index += 1

    # собираем текст обратно
    return "".join(parts)