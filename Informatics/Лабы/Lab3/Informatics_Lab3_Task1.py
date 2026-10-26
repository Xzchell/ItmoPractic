import re

VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ"
CONSONANTS = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ"
# абеау
pattern = re.compile(
    rf'[А-Яа-яЁё]*[{VOWELS}]{{2}}[А-Яа-яЁё]*'
    rf'(?=\s+(?![А-Яа-яЁё]*(?:[{CONSONANTS}][А-Яа-яЁё]*){{4}})[А-Яа-яЁё]+\b)'
)

def find_words(txt):
    return " ".join(pattern.findall(txt))