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




## Configuration
There are overal 4 different configuration files which are handled in YAML. These configuration files are very easy to customise. The 4 files included in the plugin:

- Locations.yml
- Messages.yml
- Kits.yml
- Config.yml

### Kits.yml
```

{key}:
   permission: {permission}
   icon:
     name: '{string}'
     material: {material}
     slot: {integer}
     amount: {integer}
     subID: {short}
     lore:
     - '{string}'
   items:
     '{id}':
        name: '{string}'
        material: {material}
        slot: {integer}
        amount: {integer}
        subID: {short}
        lore:
        - '{string}'
```

### Locations.yml
```
Lobby:
  ==: org.bukkit.Location
  world: world
  x: 153.3843696362059
  y: 71.0
  z: 279.23702593778705
  pitch: 6.743538
  yaw: 358.3838
  
Spawns:
  '1':
    ==: org.bukkit.Location
    world: world
    x: 158.66308406253458
    y: 71.0
    z: 281.2793426178278
    pitch: 8.245577
    yaw: 359.886
  '2':
    ==: org.bukkit.Location
    world: world
    x: 156.56620838659055
    y: 71.0
    z: 281.48167353595807
    pitch: 12.966307
    yaw: 359.0274
```


