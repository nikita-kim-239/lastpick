DELETE
FROM victimship;
DELETE
FROM friendship;
DELETE
FROM heroes;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1;

insert into heroes (name)
values ('Abaddon');
insert into heroes (name)
values ('Alchemist');
insert into heroes (name)
values ('Ancient Apparition');
insert into heroes (name)
values ('Anti-Mage');
insert into heroes (name)
values ('Arc Warden');
insert into heroes (name)
values ('Axe');
insert into heroes (name)
values ('Bane');
insert into heroes (name)
values ('Batrider');
insert into heroes (name)
values ('Beastmaster');
insert into heroes (name)
values ('Bloodseeker');
insert into heroes (name)
values ('Bounty Hunter');
insert into heroes (name)
values ('Brewmaster');
insert into heroes (name)
values ('Bristleback');
insert into heroes (name)
values ('Broodmother');
insert into heroes (name)
values ('Centaur Warrunner');
insert into heroes (name)
values ('Chaos Knight');
insert into heroes (name)
values ('Chen');
insert into heroes (name)
values ('Clinkz');
insert into heroes (name)
values ('Clockwerk');
insert into heroes (name)
values ('Crystal Maiden');
insert into heroes (name)
values ('Dark Seer');
insert into heroes (name)
values ('Dark Willow');
insert into heroes (name)
values ('Dawnbreaker');
insert into heroes (name)
values ('Dazzle');
insert into heroes (name)
values ('Death Prophet');
insert into heroes (name)
values ('Disruptor');
insert into heroes (name)
values ('Doom');
insert into heroes (name)
values ('Dragon Knight');
insert into heroes (name)
values ('Drow Ranger');
insert into heroes (name)
values ('Earth Spirit');
insert into heroes (name)
values ('Earthshaker');
insert into heroes (name)
values ('Elder Titan');
insert into heroes (name)
values ('Ember Spirit');
insert into heroes (name)
values ('Enchantress');
insert into heroes (name)
values ('Enigma');
insert into heroes (name)
values ('Faceless Void');
insert into heroes (name)
values ('Grimstroke');
insert into heroes (name)
values ('Gyrocopter');
insert into heroes (name)
values ('Hoodwink');
insert into heroes (name)
values ('Huskar');
insert into heroes (name)
values ('Invoker');
insert into heroes (name)
values ('Io');
insert into heroes (name)
values ('Jakiro');
insert into heroes (name)
values ('Juggernaut');
insert into heroes (name)
values ('Keeper of the Light');
insert into heroes (name)
values ('Kunkka');
insert into heroes (name)
values ('Legion Commander');
insert into heroes (name)
values ('Leshrac');
insert into heroes (name)
values ('Lich');
insert into heroes (name)
values ('Lifestealer');
insert into heroes (name)
values ('Lina');
insert into heroes (name)
values ('Lion');
insert into heroes (name)
values ('Lone Druid');
insert into heroes (name)
values ('Luna');
insert into heroes (name)
values ('Lycan');
insert into heroes (name)
values ('Magnus');
insert into heroes (name)
values ('Marci');
insert into heroes (name)
values ('Mars');
insert into heroes (name)
values ('Medusa');
insert into heroes (name)
values ('Meepo');
insert into heroes (name)
values ('Mirana');
insert into heroes (name)
values ('Monkey King');
insert into heroes (name)
values ('Morphling');
insert into heroes (name)
values ('Muerta');
insert into heroes (name)
values ('Naga Siren');
insert into heroes (name)
values ('Nature`s Prophet');
insert into heroes (name)
values ('Necrophos');
insert into heroes (name)
values ('Night Stalker');
insert into heroes (name)
values ('Nyx Assassin');
insert into heroes (name)
values ('Ogre Magi');
insert into heroes (name)
values ('Omniknight');
insert into heroes (name)
values ('Oracle');
insert into heroes (name)
values ('Outworld Destroyer');
insert into heroes (name)
values ('Pangolier');
insert into heroes (name)
values ('Phantom Assassin');
insert into heroes (name)
values ('Phantom Lancer');
insert into heroes (name)
values ('Phoenix');
insert into heroes (name)
values ('Puck');
insert into heroes (name)
values ('Pudge');
insert into heroes (name)
values ('Pugna');
insert into heroes (name)
values ('Queen of Pain');
insert into heroes (name)
values ('Razor');
insert into heroes (name)
values ('Riki');
insert into heroes (name)
values ('Rubick');
insert into heroes (name)
values ('Sand King');
insert into heroes (name)
values ('Shadow Demon');
insert into heroes (name)
values ('Shadow Fiend');
insert into heroes (name)
values ('Shadow Shaman');
insert into heroes (name)
values ('Silencer');
insert into heroes (name)
values ('Skywrath Mage');
insert into heroes (name)
values ('Slardar');
insert into heroes (name)
values ('Slark');
insert into heroes (name)
values ('Snapfire');
insert into heroes (name)
values ('Sniper');
insert into heroes (name)
values ('Spectre');
insert into heroes (name)
values ('Spirit Breaker');
insert into heroes (name)
values ('Storm Spirit');
insert into heroes (name)
values ('Sven');
insert into heroes (name)
values ('Techies');
insert into heroes (name)
values ('Templar Assassin');
insert into heroes (name)
values ('Terrorblade');
insert into heroes (name)
values ('Tidehunter');
insert into heroes (name)
values ('Timbersaw');
insert into heroes (name)
values ('Tinker');
insert into heroes (name)
values ('Tiny');
insert into heroes (name)
values ('Treant Protector');
insert into heroes (name)
values ('Troll Warlord');
insert into heroes (name)
values ('Tusk');
insert into heroes (name)
values ('Underlord');
insert into heroes (name)
values ('Undying');
insert into heroes (name)
values ('Ursa');
insert into heroes (name)
values ('Vengeful Spirit');
insert into heroes (name)
values ('Venomancer');
insert into heroes (name)
values ('Viper');
insert into heroes (name)
values ('Visage');
insert into heroes (name)
values ('Void Spirit');
insert into heroes (name)
values ('Warlock');
insert into heroes (name)
values ('Weaver');
insert into heroes (name)
values ('Windranger');
insert into heroes (name)
values ('Winter Wyvern');
insert into heroes (name)
values ('Witch Doctor');
insert into heroes (name)
values ('Wraith King');
insert into heroes (name)
values ('Zeus');



insert into victimship (predator_id, victim_id)
values (1, 5);
insert into victimship (predator_id, victim_id)
values (1, 6);
insert into victimship (predator_id, victim_id)
values (1, 7);
insert into victimship (predator_id, victim_id)
values (1, 8);
insert into victimship (predator_id, victim_id)
values (1, 11);
insert into victimship (predator_id, victim_id)
values (1, 12);
insert into victimship (predator_id, victim_id)
values (1, 18);
insert into victimship (predator_id, victim_id)
values (1, 27);
insert into victimship (predator_id, victim_id)
values (1, 30);
insert into victimship (predator_id, victim_id)
values (1, 35);
insert into victimship (predator_id, victim_id)
values (1, 44);
insert into victimship (predator_id, victim_id)
values (1, 47);
insert into victimship (predator_id, victim_id)
values (1, 60);
insert into victimship (predator_id, victim_id)
values (1, 75);
insert into victimship (predator_id, victim_id)
values (1, 77);
insert into victimship (predator_id, victim_id)
values (1, 79);
insert into victimship (predator_id, victim_id)
values (1, 88);
insert into victimship (predator_id, victim_id)
values (1, 93);
insert into victimship (predator_id, victim_id)
values (1, 95);
insert into victimship (predator_id, victim_id)
values (1, 111);
insert into victimship (predator_id, victim_id)
values (2, 1);
insert into victimship (predator_id, victim_id)
values (2, 4);
insert into victimship (predator_id, victim_id)
values (2, 14);
insert into victimship (predator_id, victim_id)
values (2, 15);
insert into victimship (predator_id, victim_id)
values (2, 17);
insert into victimship (predator_id, victim_id)
values (2, 42);
insert into victimship (predator_id, victim_id)
values (2, 53);
insert into victimship (predator_id, victim_id)
values (2, 55);
insert into victimship (predator_id, victim_id)
values (2, 70);
insert into victimship (predator_id, victim_id)
values (2, 75);
insert into victimship (predator_id, victim_id)
values (2, 76);
insert into victimship (predator_id, victim_id)
values (2, 81);
insert into victimship (predator_id, victim_id)
values (2, 93);
insert into victimship (predator_id, victim_id)
values (2, 100);
insert into victimship (predator_id, victim_id)
values (2, 102);
insert into victimship (predator_id, victim_id)
values (2, 107);
insert into victimship (predator_id, victim_id)
values (2, 113);
insert into victimship (predator_id, victim_id)
values (2, 114);
insert into victimship (predator_id, victim_id)
values (2, 120);
insert into victimship (predator_id, victim_id)
values (2, 121);
insert into victimship (predator_id, victim_id)
values (4, 41);
insert into victimship (predator_id, victim_id)
values (4, 120);
insert into victimship (predator_id, victim_id)
values (4, 121);
insert into victimship (predator_id, victim_id)
values (6, 4);
insert into victimship (predator_id, victim_id)
values (9, 4);
insert into victimship (predator_id, victim_id)
values (9, 36);
insert into victimship (predator_id, victim_id)
values (10, 11);
insert into victimship (predator_id, victim_id)
values (11, 81);
insert into victimship (predator_id, victim_id)
values (13, 4);
insert into victimship (predator_id, victim_id)
values (16, 109);
insert into victimship (predator_id, victim_id)
values (26, 4);
insert into victimship (predator_id, victim_id)
values (30, 92);
insert into victimship (predator_id, victim_id)
values (31, 59);
insert into victimship (predator_id, victim_id)
values (31, 63);
insert into victimship (predator_id, victim_id)
values (31, 74);
insert into victimship (predator_id, victim_id)
values (41, 21);
insert into victimship (predator_id, victim_id)
values (41, 58);
insert into victimship (predator_id, victim_id)
values (41, 59);
insert into victimship (predator_id, victim_id)
values (50, 121);
insert into victimship (predator_id, victim_id)
values (53, 4);
insert into victimship (predator_id, victim_id)
values (58, 16);
insert into victimship (predator_id, victim_id)
values (58, 97);
insert into victimship (predator_id, victim_id)
values (58, 108);
insert into victimship (predator_id, victim_id)
values (60, 3);
insert into victimship (predator_id, victim_id)
values (60, 19);
insert into victimship (predator_id, victim_id)
values (60, 36);
insert into victimship (predator_id, victim_id)
values (60, 66);
insert into victimship (predator_id, victim_id)
values (60, 90);
insert into victimship (predator_id, victim_id)
values (60, 92);
insert into victimship (predator_id, victim_id)
values (60, 108);
insert into victimship (predator_id, victim_id)
values (62, 73);
insert into victimship (predator_id, victim_id)
values (74, 109);
insert into victimship (predator_id, victim_id)
values (74, 120);
insert into victimship (predator_id, victim_id)
values (75, 28);
insert into victimship (predator_id, victim_id)
values (83, 59);
insert into victimship (predator_id, victim_id)
values (89, 81);
insert into victimship (predator_id, victim_id)
values (92, 58);
insert into victimship (predator_id, victim_id)
values (92, 65);
insert into victimship (predator_id, victim_id)
values (92, 86);
insert into victimship (predator_id, victim_id)
values (92, 107);
insert into victimship (predator_id, victim_id)
values (93, 97);
insert into victimship (predator_id, victim_id)
values (94, 29);
insert into victimship (predator_id, victim_id)
values (94, 92);
insert into victimship (predator_id, victim_id)
values (97, 116);
insert into victimship (predator_id, victim_id)
values (98, 71);
insert into victimship (predator_id, victim_id)
values (98, 76);
insert into victimship (predator_id, victim_id)
values (101, 74);
insert into victimship (predator_id, victim_id)
values (106, 121);
insert into victimship (predator_id, victim_id)
values (113, 97);
insert into victimship (predator_id, victim_id)
values (120, 36);
insert into victimship (predator_id, victim_id)
values (120, 9);
insert into victimship (predator_id, victim_id)
values (121, 3);
insert into victimship (predator_id, victim_id)
values (121, 6);
insert into victimship (predator_id, victim_id)
values (121, 10);
insert into victimship (predator_id, victim_id)
values (121, 21);
insert into victimship (predator_id, victim_id)
values (121, 29);
insert into victimship (predator_id, victim_id)
values (121, 31);
insert into victimship (predator_id, victim_id)
values (121, 32);
insert into victimship (predator_id, victim_id)
values (121, 35);
insert into victimship (predator_id, victim_id)
values (121, 38);
insert into victimship (predator_id, victim_id)
values (121, 54);
insert into victimship (predator_id, victim_id)
values (121, 58);
insert into victimship (predator_id, victim_id)
values (121, 61);
insert into victimship (predator_id, victim_id)
values (121, 63);
insert into victimship (predator_id, victim_id)
values (121, 65);
insert into victimship (predator_id, victim_id)
values (121, 73);
insert into victimship (predator_id, victim_id)
values (121, 74);
insert into victimship (predator_id, victim_id)
values (121, 81);
insert into victimship (predator_id, victim_id)
values (121, 83);
insert into victimship (predator_id, victim_id)
values (121, 85);
insert into victimship (predator_id, victim_id)
values (121, 92);
insert into victimship (predator_id, victim_id)
values (121, 99);
insert into victimship (predator_id, victim_id)
values (121, 102);
insert into victimship (predator_id, victim_id)
values (121, 116);
insert into victimship (predator_id, victim_id)
values (121, 118);



insert into friendship (hero1_id, hero2_id)
values (2, 89);
insert into friendship (hero1_id, hero2_id)
values (2, 98);
insert into friendship (hero1_id, hero2_id)
values (3, 10);
insert into friendship (hero1_id, hero2_id)
values (4, 41);
insert into friendship (hero1_id, hero2_id)
values (6, 1);
insert into friendship (hero1_id, hero2_id)
values (6, 38);
insert into friendship (hero1_id, hero2_id)
values (6, 69);
insert into friendship (hero1_id, hero2_id)
values (9, 43);
insert into friendship (hero1_id, hero2_id)
values (9, 88);
insert into friendship (hero1_id, hero2_id)
values (10, 41);
insert into friendship (hero1_id, hero2_id)
values (10, 121);
insert into friendship (hero1_id, hero2_id)
values (19, 10);
insert into friendship (hero1_id, hero2_id)
values (19, 41);
insert into friendship (hero1_id, hero2_id)
values (20, 41);
insert into friendship (hero1_id, hero2_id)
values (20, 88);
insert into friendship (hero1_id, hero2_id)
values (20, 95);
insert into friendship (hero1_id, hero2_id)
values (20, 121);
insert into friendship (hero1_id, hero2_id)
values (21, 79);
insert into friendship (hero1_id, hero2_id)
values (24, 14);
insert into friendship (hero1_id, hero2_id)
values (24, 40);
insert into friendship (hero1_id, hero2_id)
values (24, 59);
insert into friendship (hero1_id, hero2_id)
values (30, 10);
insert into friendship (hero1_id, hero2_id)
values (33, 20);
insert into friendship (hero1_id, hero2_id)
values (33, 21);
insert into friendship (hero1_id, hero2_id)
values (35, 41);
insert into friendship (hero1_id, hero2_id)
values (35, 49);
insert into friendship (hero1_id, hero2_id)
values (36, 41);
insert into friendship (hero1_id, hero2_id)
values (36, 88);
insert into friendship (hero1_id, hero2_id)
values (41, 47);
insert into friendship (hero1_id, hero2_id)
values (41, 48);
insert into friendship (hero1_id, hero2_id)
values (41, 83);
insert into friendship (hero1_id, hero2_id)
values (41, 100);
insert into friendship (hero1_id, hero2_id)
values (42, 54);
insert into friendship (hero1_id, hero2_id)
values (42, 92);
insert into friendship (hero1_id, hero2_id)
values (43, 36);
insert into friendship (hero1_id, hero2_id)
values (44, 56);
insert into friendship (hero1_id, hero2_id)
values (44, 111);
insert into friendship (hero1_id, hero2_id)
values (50, 89);
insert into friendship (hero1_id, hero2_id)
values (50, 94);
insert into friendship (hero1_id, hero2_id)
values (51, 83);
insert into friendship (hero1_id, hero2_id)
values (54, 110);
insert into friendship (hero1_id, hero2_id)
values (57, 49);
insert into friendship (hero1_id, hero2_id)
values (57, 75);
insert into friendship (hero1_id, hero2_id)
values (58, 20);
insert into friendship (hero1_id, hero2_id)
values (60, 7);
insert into friendship (hero1_id, hero2_id)
values (61, 56);
insert into friendship (hero1_id, hero2_id)
values (61, 69);
insert into friendship (hero1_id, hero2_id)
values (70, 24);
insert into friendship (hero1_id, hero2_id)
values (79, 9);
insert into friendship (hero1_id, hero2_id)
values (79, 13);
insert into friendship (hero1_id, hero2_id)
values (79, 48);
insert into friendship (hero1_id, hero2_id)
values (79, 56);
insert into friendship (hero1_id, hero2_id)
values (79, 78);
insert into friendship (hero1_id, hero2_id)
values (79, 120);
insert into friendship (hero1_id, hero2_id)
values (91, 35);
insert into friendship (hero1_id, hero2_id)
values (95, 50);
insert into friendship (hero1_id, hero2_id)
values (96, 35);
insert into friendship (hero1_id, hero2_id)
values (97, 77);
insert into friendship (hero1_id, hero2_id)
values (97, 103);
insert into friendship (hero1_id, hero2_id)
values (98, 21);
insert into friendship (hero1_id, hero2_id)
values (98, 70);
insert into friendship (hero1_id, hero2_id)
values (119, 58);



insert into victimship (victim_id, predator_id)
values (73, 31);
insert into victimship (victim_id, predator_id)
values (73, 60);
insert into victimship (victim_id, predator_id)
values (73, 51);
insert into victimship (victim_id, predator_id)
values (73, 75);
insert into victimship (victim_id, predator_id)
values (73, 30);
insert into victimship (victim_id, predator_id)
values (73, 6);
insert into victimship (victim_id, predator_id)
values (73, 65);
insert into victimship (victim_id, predator_id)
values (73, 54);
insert into victimship (victim_id, predator_id)
values (73, 101);
insert into victimship (victim_id, predator_id)
values (73, 16);
insert into victimship (victim_id, predator_id)
values (27, 120);
insert into victimship (victim_id, predator_id)
values (27, 74);
insert into victimship (victim_id, predator_id)
values (79, 4);
insert into victimship (victim_id, predator_id)
values (60, 94);


insert into users (username, password)
values ('nikita', '{bcrypt}$2a$10$TZz7S3VRKZ1r9CA/eauSLeBtdom8Dncjx4qXp2N.v3JQkWxL0cO.6');