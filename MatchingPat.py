
# def filter_validation(searchSpace, filter_values):
#     for searchDict in searchSpace:
#         has_matched = True;
#         for filter_value in filter_values:
#             if filter_value not in searchDict and searchDict[filter_value] != filter_values[filter_value]:
#                 has_matched = False;
#                 break;
#         if has_matched:
#             print(searchDict["Uuid"], " is maching the conditions - ", filter_values)

# Jo bhi search krna ho uski key and value "filter_values" wale dictonary me dal dena
# aur "searchSpace" tmhara output wala dictonary h
# to "filter_validation" function tmhara check krega ki agr output wale dictory me tmhare filter_values hain ya nahi
# or agr hain to uki vlues bhi wahi h ya nhi jo tmne specify ki h
# agr han to fir vo uski UUID print kr dega other wise nhi krega.


# arrow after function name '-> [return type]' tells what will be the return type from this function, 
# Python will itself understand if you don't specify it, but I have added just for type safety. 

def filter_validation(searchSpace, filter_values) -> list:

    mismatches : list = []# Will store all the mismatch UUID in this list, then return this list.

    if not bool(filter_values):
        print("filter_values is empty")
        return mismatches # if filter_values is empty then will emtpy mismatch list

    # Iterating over the search space
    for searchDict in searchSpace:

        # validating if searchDict is empty if so, continue to next searchDict
        if not bool(searchDict):
            print("Search Space is empty!!")
            continue

        for filter_key in filter_values:
            if filter_key in searchDict:
                for filter_val in filter_values[filter_key]:
                    if searchDict[filter_key] == filter_val:
                        mismatches.append(searchDict["Uuid"]) # Adding mismatch UUID to this list
                        # print(
                        #     searchDict["Uuid"], " is maching the conditions - {", filter_key, " : ", filter_val, "}")
            # else:
                # print(searchDict["Uuid"], " does not have ", filter_key)
    return mismatches


searchSpace = [
    {
        "Uuid": "6a25d524-210f-4239-bd53-9ebeda18ff16",
        "phys-address": "81:ba:ad:61:01:03",
        "name": "ens-3",
        "type": "vlan",
        "speed": 200,
        "enabled": False
    },
    {
        "Uuid": "6a25d524-210f-4239-bd53-9ebeda18ff16",
        "phys-address": "81:ba:ad:61:01:03",
        "name": "ens-3",
        "type": "vlan",
        "speed": 500,
        "enabled": False
    },
    {
        "Uuid": "6a25d524-210f-4239-bd53-9ebeda18ff16",
        "phys-address": "81:ba:ad:61:01:03",
        "name": "ens-3",
        "type": "vlan",
        "speed": 100,
        "enabled": False
    }]

filter_values = {
    "speed": [200, 100, 400],
    "type": ["vlan"],
    "name": ["ens-3"],
    "Something": ["test value"]
}

mismatches = filter_validation(searchSpace, filter_values)

print(f'Mismatch Found for UUIDs- {mismatches}')
