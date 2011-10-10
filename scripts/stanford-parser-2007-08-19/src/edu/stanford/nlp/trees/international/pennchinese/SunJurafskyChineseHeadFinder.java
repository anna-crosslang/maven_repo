package edu.stanford.nlp.trees.international.pennchinese;

import edu.stanford.nlp.trees.AbstractCollinsHeadFinder;
import edu.stanford.nlp.trees.TreebankLanguagePack;

import java.util.HashMap;

/**
 * A headfinder for Chinese based on rules described in Sun/Jurafsky NAACL '04.
 *
 * @author Galen Andrew
 * @version Jul 12, 2004
 */
public class SunJurafskyChineseHeadFinder extends AbstractCollinsHeadFinder {

  public SunJurafskyChineseHeadFinder() {
    this(new ChineseTreebankLanguagePack());
  }

  public SunJurafskyChineseHeadFinder(TreebankLanguagePack tlp) {
    super(tlp);

    defaultRule = new String[]{"right"};

    nonTerminalInfo = new HashMap();

    nonTerminalInfo.put("ROOT", new String[][]{{"left", "IP"}});
    nonTerminalInfo.put("PAIR", new String[][]{{"left", "IP"}});

    nonTerminalInfo.put("ADJP", new String[][]{{"right", "ADJP", "JJ", "AD"}});
    nonTerminalInfo.put("ADVP", new String[][]{{"right", "ADVP", "AD", "CS", "JJ", "NP", "PP", "P", "VA", "VV"}});
    nonTerminalInfo.put("CLP", new String[][]{{"right", "CLP", "M", "NN", "NP"}});
    nonTerminalInfo.put("CP", new String[][]{{"right", "CP", "IP", "VP"}});
    nonTerminalInfo.put("DNP", new String[][]{{"right", "DEG", "DNP", "DEC", "QP"}});
    nonTerminalInfo.put("DP", new String[][]{{"left", "M", "DP", "DT", "OD"}});
    nonTerminalInfo.put("DVP", new String[][]{{"right", "DEV", "AD", "VP"}});
    nonTerminalInfo.put("IP", new String[][]{{"right", "VP", "IP", "NP"}});
    nonTerminalInfo.put("LCP", new String[][]{{"right", "LCP", "LC"}});
    nonTerminalInfo.put("LST", new String[][]{{"right", "CD", "NP", "QP"}});
    nonTerminalInfo.put("NP", new String[][]{{"right", "NP", "NN", "IP", "NR", "NT"}});
    nonTerminalInfo.put("PP", new String[][]{{"left", "P", "PP"}});
    nonTerminalInfo.put("PRN", new String[][]{{"left", "PU"}});
    nonTerminalInfo.put("QP", new String[][]{{"right", "QP", "CLP", "CD"}});
    nonTerminalInfo.put("UCP", new String[][]{{"left", "IP", "NP", "VP"}});
    nonTerminalInfo.put("VCD", new String[][]{{"left", "VV", "VA", "VE"}});
    nonTerminalInfo.put("VP", new String[][]{{"left", "VE", "VC", "VV", "VNV", "VPT", "VRD", "VSB", "VCD", "VP"}});
    nonTerminalInfo.put("VPT", new String[][]{{"left", "VA", "VV"}});
    nonTerminalInfo.put("VCP", new String[][]{{"left"}});
    nonTerminalInfo.put("VNV", new String[][]{{"left"}});
    nonTerminalInfo.put("VRD", new String[][]{{"left", "VV", "VA"}});
    nonTerminalInfo.put("VSB", new String[][]{{"right", "VV", "VE"}});
    nonTerminalInfo.put("FRAG", new String[][]{{"right", "VV", "NN"}}); //FRAG seems only to be used for bits at the beginnings of articles: "Xinwenshe<DATE>" and "(wan)"

    // some POS tags apparently sit where phrases are supposed to be
    nonTerminalInfo.put("CD", new String[][]{{"right", "CD"}});
    nonTerminalInfo.put("NN", new String[][]{{"right", "NN"}});
    nonTerminalInfo.put("NR", new String[][]{{"right", "NR"}});

    // I'm adding these POS tags to do primitive morphology for character-level
    // parsing.  It shouldn't affect anything else because heads of preterminals are not
    // generally queried - GMA
    nonTerminalInfo.put("VV", new String[][]{{"left"}});
    nonTerminalInfo.put("VA", new String[][]{{"left"}});
    nonTerminalInfo.put("VC", new String[][]{{"left"}});
    nonTerminalInfo.put("VE", new String[][]{{"left"}});
  }

}
