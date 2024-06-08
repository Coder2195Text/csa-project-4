
# Table of Contents
1. [About](#about)
2. [Problem](#problem)
3. [Recursion](#recursion)
4. [Attributions](#attributions)


# About
A school project where I just modded Minecraft.

# Problem: (This is for project requirements):
Minecraft is slowly dying, and seeing many of us are Americans, I can revive it by adding American features like guns and grenades and stuff to the game.

# Recursion:
Performing a giveaway, so there is a piece of code that will shuffle an array and pick the first element. Person will get free Roblox merch.
```javascript
function shuffleArray(arr, n = arr.length) {
    // Base case: if the array has only one element, it's already shuffled
    if (n <= 1) {console.log(arr, 0); return;}

    // Pick a random index from 0 to n-1
    const randomIndex = Math.floor(Math.random() * n);

    // Swap the element at randomIndex with the element at n-1
    [arr[randomIndex], arr[n-1]] = [arr[n-1], arr[randomIndex]];

    // Recursively shuffle the first n-1 elements
    shuffleArray(arr, n - 1);
}

// Example usage:
const array = `Victor Augustus

Fatoumata Barry

Reem Belafkih

Shun Yi Chen

Hamzah Kazmi

Samuel Lewin

Evan Liang

Teo Liang

Yuxuan Liang

Eric Lin

Matthew Lin

Zachary Lin

Donovan Liu

Daler Muradov

Isabella Poon

Syon Rahman

Saajid Sadakat

Yasmin Samigdjanova

Nelson Senhouse

Eaton Song

Terry Tang

Preston Thomas-White

Toshinori Underwood

Raymond Weng

Linbin Wu

Weihao Wu

Sumya Zahin`.split("\n\n");
shuffleArray(array);
```

# Attributions

AR-15 [Colt AR-15 - Ferdik04_CZ](https://www.planetminecraft.com/texture-pack/colt-ar-15-pack/)

Other gun models [Hardt's Guns 3D - SrDarmith ft Mainclay](https://www.planetminecraft.com/texture-pack/hardt-s-guns-3d/)

Gun sounds [MrCrayfish's Gun Mod - MrCrayfish](https://github.com/MrCrayfish/MrCrayfishGunMod)

Provided good insight into undocumented stuff [Lyinginbedmon/TricksyFoxes](https://github.com/Lyinginbedmon/TricksyFoxes)

Blockbench used to model and convert models [Blockbench](https://blockbench.net/)

Since Bedrock addons are heavily pirated, this site is not the original site. [M1A2 Abrams addon by MyoHtet @bmheades on X](https://mc-addons.com/mods/mods-116/765-m1a2-abrams-tank-addon.html)

Cannon fire: [Cannon Fire - LordSonny](https://pixabay.com/sound-effects/cannon-fire-161072/)

Flashbang: [Youtube - Psuedonymous](https://www.youtube.com/watch?v=w-Hr3XFJ8FA)