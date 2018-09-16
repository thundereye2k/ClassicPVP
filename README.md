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


#Configuration
There are overal 4 different configuration files which are handled in YAML. These configuration files are very easy to customise. The 4 files included in the plugin:

- Locations.yml
- Messages.yml
- Kits.yml
- Config.yml

```
Settings:
  clear-join-inventory: false
  soup: true
  block-break: true
  block-place: true
  item-drop: true
  item-pickup: true
  fall: true
  hunger: true

Menu:
  kits:
    name: 'Kits'
    size: 27
  preview:
    name: 'Preview'
    size: 54

Help:
  - '&e&lPVP Commands:'
  - '&7Contact &bStefTheDev &7for support!'
  - ''
  - '  &b&l1. &7/pvp addspawn'
  - '  &b&l2. &7/pvp delspawn'
  - '  &b&l3. &7/pvp clearspawns'
  - '  &b&l4. &7/pvp setlobby'
  - '  &b&l5. &7/pvp reload'

Items:
  soup:
    name: '&e&lShoup &7(Yummy)'
    material: BOWL
    subID: 0
    lore:
      - '&f&oClick to consume!'
  leave:
    name: '&c&lLeave &7(Right-Click)'
    slot: 8
    material: SLIME_BALL
    amount: 1
    subID: 0
    lore:
      - '&f&oClick to select!'
  kits:
    name: '&a&lKits &7(Right-Click)'
    slot: 0
    material: PISTON_BASE
    amount: 1
    subID: 0
    lore:
      - '&f&oClick to select!'
```


