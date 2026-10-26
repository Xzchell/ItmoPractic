# Author = Bolshakov Vladislav Sergeevich
# Group = P3115
# Date = 26.10.2026

import re
part1 = "^([A-Za-z0-9._]+)"
part2 = "([A-Za-z]+(?:\.[A-Za-z]+)+)$"
pattern = re.compile(rf'^{part1}@{part2}')

def check_email(txt):
    match = pattern.fullmatch(txt)

    if match:
        return match.group(2)

    return "Fail!"