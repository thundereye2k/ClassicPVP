# ClassicPVP
An amazing, lightweight pvp experience. 100% Customisable

Features:
- 100% Customisable
- Optimised data Serialisation/Deserialisation
- Kit: [Enchantment, Menu, ItemMeta Attributes removal, Slots]
- Locations: [Multiple Spawns Teleportation, Lobby Location]
- Settings: [Fall damage, item drop, block breaking etc]
- You can add as many spawns you desire.
- Custom Join Items
- PvP Soup
- Super Lightweight




# Configuration
There are overal 4 different configuration files which are handled in YAML. These configuration files are very easy to customise. The 4 files included in the plugin:

- Locations.yml
- Messages.yml
- Kits.yml
- Config.yml

Kits.yml
```
{key}:
   permission: {permission}
   icon:
     name: '{string}'
     material: {material}
     slot: {integer}
     amount: {integer}
     subID: {short}
     lore: #StringList
     - {string}
   items:
     '{id}':
        name: '{string}'
        material: {material}
        slot: {integer}
        amount: {integer}
        subID: {short}
        lore: #StringList
        - {string}
```


