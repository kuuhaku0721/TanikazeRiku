package com.tanikazeriku.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Blob;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterCard implements Serializable {
    public int id;
    public String name;
    public byte[] image;
    public int hp;
    public int mp;
    public int skill_id;
    public int destroy;
    public int growth;
    public int precision;
    public int sustain;
    public int distance;
    public int speed;
}
