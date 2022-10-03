def filter_validation(searchSpace, filter_values):
    for searchDict in searchSpace:
        has_matched = True;
        for filter_value in filter_values:
            if filter_value not in searchDict and searchDict[filter_value] != filter_values[filter_value]:
                has_matched = False;
                break;
        if has_matched:
            print(searchDict["Uuid"], " is maching the conditions - ", filter_values)


searchSpace = [
        {
            "Uuid":"6a25d524-210f-4239-bd53-9ebeda18ff16",
            "phys-address":"81:ba:ad:61:01:03",
            "name":"ens-3",
            "type":"vlan",
            "speed":200,
            "enabled":False
        },
        {
            "Uuid":"6a25d524-210f-4239-bd53-9ebeda18ff16",
            "phys-address":"81:ba:ad:61:01:03",
            "name":"ens-3",
            "type":"vlan",
            "speed":200,
            "enabled":False
        }]

filter_values = {
    "speed": 200,
    "type": "vlan",
    "name": "ens-3"
}



# Jo bhi search krna ho uski key and value "filter_values" wale dictonary me dal dena 
# aur "searchSpace" tmhara output wala dictonary h 
# to "filter_validation" function tmhara check krega ki agr output wale dictory me tmhare filter_values hain ya nahi 
# or agr hain to uki vlues bhi wahi h ya nhi jo tmne specify ki h 
# agr han to fir vo uski UUID print kr dega other wise nhi krega. 

filter_validation(searchSpace, filter_values)
