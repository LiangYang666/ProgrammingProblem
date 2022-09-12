package com.liang.Interview;


import java.util.*;

/*
每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，
例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，
另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，
则 John 与 Johnny 也相同，即它们有传递和对称性。
在结果列表中，选择 字典序最小 的名字作为真实名字。


示例：
输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
输出：["John(27)","Chris(36)"]
 */
public class MInterview面试题17_07婴儿的名字 {
    public static void main(String[] args) {
        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] names2 = {"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[] synonyms2 = {"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"};
        System.out.println(Arrays.toString(trulyMostPopular1(names2, synonyms2)));
    }
    static Map<String, String> m = new HashMap<>();

    static
    String find(String name){
        if(name.equals(m.get(name))){
            return name;
        } else {
            return find(m.get(name));
        }
    }
    static
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        //卡在22例
        String[][] names_synonym = new String[synonyms.length][2];
        for (int i = 0; i < synonyms.length; i++) {
            String[] synonym = synonyms[i].split(",");
            synonym[0] = synonym[0].substring(synonym[0].indexOf("(")+1);
            synonym[1] = synonym[1].substring(0, synonym[1].indexOf(")"));
            Arrays.sort(synonym);
            names_synonym[i][0] = synonym[0];
            names_synonym[i][1] = synonym[1];
            m.putIfAbsent(synonym[0], synonym[0]);
            m.putIfAbsent(synonym[1], synonym[1]);
        }
        // System.out.println(m);
        for (String[] strings : names_synonym) {
            String f0 = find(m.get(strings[0]));
            String f1 = find(m.get(strings[1]));
            if(!f0.equals(f1)){
                if(f0.compareTo(f1)>0){
                    m.put(f0, f1);
                } else {
                    m.put(f1, f0);
                }
            }
        }
        HashMap<String, Integer> nameNum = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String strings[] = names[i].trim().split("[\\)\\(]");
            String trueName;
            if(!m.containsKey(strings[0])){
                trueName = strings[0];
            } else {
                trueName = find(strings[0]);
            }
            int n = Integer.parseInt(strings[1]);
            nameNum.putIfAbsent(trueName, 0);
            nameNum.put(trueName, nameNum.get(trueName)+n);
        }
        String[] rs = new String[nameNum.keySet().size()];
        int i=0;
        for (String key :
                nameNum.keySet()) {
            rs[i++] = key+"("+nameNum.get(key)+")";
        }
        return rs;
    }
    static
    public String[] trulyMostPopular1(String[] names, String[] synonyms) {
        //别人的方法
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {     //统计频率
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.valueOf(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms) {  //union同义词
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)) {   //找name1祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {   //找name2祖宗
                name2 = unionMap.get(name2);
            }
            if(!name1.equals(name2)){   //祖宗不同，要合并
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);    //出现次数是两者之和
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                map.remove(nickName);       //更新一下数据
                map.put(trulyName, frequency);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(map.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;

    }
}


/*
["Nzaz(51)","Gbkq(77)","Gauuk(75)","Chycnm(253)","Axwtno(57)","Chhmx(259)","Mtz(72)","Hfp(97)","Ijveol(46)","Koaak(53)","Jfq(26)","Mwwvj(70)","Bnea(179)","Ntfr(70)","Avcp(41)","Obcbxb(124)","Jvqg(47)","Npilye(25)","Fcclu(70)","Qbmk(45)","Gnplfi(109)","Dwifi(237)","Fpaf(219)","Yeekgc(11)","Ard(82)","Kgabb(236)","Weusps(79)","Nekuam(17)","Qyqifg(85)","Alrksy(69)","Avmzs(39)","Acohsf(86)","Ibink(32)","Qiy(26)","Dhe(79)","Ebov(96)","Onnev(77)","Hljt(51)","Yjc(94)","Ofl(72)","Csh(238)","Oltadg(95)","Fvkhz(104)","Okwuq(96)","Unsb(26)","Hcvcgc(97)","Aeax(646)","Uvkdpn(71)","Kufa(95)","Nsgbth(26)","Nuq(61)","Ucqh(51)","Dnsay(72)","Mcnef(59)","Naf(3)","Drzsnw(87)","Msyr(211)","Kasgmw(95)","Knpuq(61)"]
["Chhmx(259)","Aeax(646)","Fpaf(219)","Weusps(79)","Unsb(26)","Kgabb(236)","Csh(238)","Nekuam(17)","Avcp(41)","Drzsnw(87)","Yjc(94)","Msyr(211)","Knpuq(61)","Ard(82)","Bnea(179)","Onnev(77)","Nzaz(51)","Jvqg(47)","Kufa(95)","Obcbxb(124)","Ebov(96)","Chycnm(253)","Qbmk(45)","Koaak(53)","Dwifi(237)","Gnplfi(109)","Ofl(72)","Ucqh(51)","Hljt(51)","Acohsf(86)","Dnsay(72)","Mwwvj(70)","Uvkdpn(71)","Nsgbth(26)","Gauuk(75)","Mtz(72)","Ibink(32)","Fcclu(70)","Alrksy(69)","Mcnef(59)","Hcvcgc(97)","Ijveol(46)","Axwtno(57)","Yeekgc(11)","Fvkhz(104)","Ntfr(70)","Npilye(25)","Gbkq(77)","Hfp(97)","Naf(3)","Jfq(26)","Qyqifg(85)","Dhe(79)","Qiy(26)","Oltadg(95)","Nuq(61)","Avmzs(39)","Okwuq(96)","Kasgmw(95)"]

 */