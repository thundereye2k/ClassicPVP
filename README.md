# ClassicPVP
An amazing, lightweight pvp experience. 100% Customisable

## Features
- 100% Customisable
- Optimised data Serialisation/Deserialisation
- Kit: [Enchantment, Menu, ItemMeta Attributes removal, Slots]
- Locations: [Multiple Spawns Teleportation, Lobby Location]
- Settings: [Fall damage, item drop, block breaking etc]
- You can add as many spawns you desire.
- Custom Join Items
- PvP Soup
- Super Lightweight

## Commands
Permissions for all commands: classicpvp.admin
- /pvp addspawn | Add spawn points to your arena
- /pvp delspawn | Remove spawn points from your arena.
- /pvp setlobby | Set the global lobby for your arena.
- /pvp clearspawns | Clear all the spawns.
- /pvp reload | Reload the config [Buggy]


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

### Messages.yml
```
command-permission: You do not seem to have permissions to this command.
command-player: You must be a player to execute this command.
command-usage: 'Usage: &f{usage}'
death-player: You have been killed by &c{player}
kick-player: Thank you for playing, we hope you enjoyed.
kill-player: You have killed &a{player}
kit-player: You have chosen the &b{kit}&7 kit.
lobby-false: The lobby has not been set, please contact an administrator.
lobby-set: You have set the global lobby.
prefix: '&e&lPVP: &7'
reload: Reloading is not supported in this version, please restart the server.
spawn-add: 'You have added new spawn: &b{id}'
spawn-clear: All spawns have been cleared
spawn-false: No spawns have been set.
spawn-remove: 'You have removed spawn: &b{id}'
```


