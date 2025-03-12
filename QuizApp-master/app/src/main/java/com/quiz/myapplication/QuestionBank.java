package com.quiz.myapplication;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionBank {

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> banglaQuestions = new ArrayList<>();
       // ArrayList<Question> englishQuestions = new ArrayList<>();
        ArrayList<Question> finalQuestions = new ArrayList<>();

        // বাংলা প্রশ্ন
        banglaQuestions.add(new Question("বাংলা", "পদ্মা সেতুর দৈর্ঘ্য কত?", new String[]{"৬.১৫ কিমি", "৭.১০ কিমি", "৮.২৫ কিমি", "৫.৪০ কিমি"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় সংগীত কে রচনা করেছেন?", new String[]{"কাজী নজরুল ইসলাম", "রবীন্দ্রনাথ ঠাকুর", "সুকান্ত ভট্টাচার্য", "মাইকেল মধুসূদন দত্ত"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের মুদ্রার নাম কী?", new String[]{"টাকা", "রূপি", "ডলার", "ইউরো"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রধান নদীর নাম কী?", new String[]{"পদ্মা", "যমুনা", "মেঘনা", "সবগুলো"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশ স্বাধীনতা লাভ করে কোন সালে?", new String[]{"১৯৭১", "১৯৫২", "১৯৪৭", "১৯৬৫"}, 0));
        banglaQuestions.add(new Question("বাংলা", "পদ্মা সেতুর দৈর্ঘ্য কত?", new String[]{"৬.১৫ কিমি", "৭.১০ কিমি", "৮.২৫ কিমি", "৫.৪০ কিমি"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় ফুল কী?", new String[]{"গোলাপ", "শাপলা", "সজনে ফুল", "পদ্ম"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের স্বাধীনতার বছর কত?", new String[]{"১৯৭১", "১৯৭৫", "১৯৬৫", "১৯৮১"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় সঙ্গীত কে রচনা করেছেন?", new String[]{"কাজী নজরুল ইসলাম", "রবীন্দ্রনাথ ঠাকুর", "লালন শাহ", "জীবনানন্দ দাশ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "কোন নদীকে বাংলাদেশে বলা হয় 'জীবন রেখা'?", new String[]{"যমুনা", "মেঘনা", "পদ্মা", "কর্ণফুলী"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বঙ্গবন্ধু শেখ মুজিবুর রহমানের জন্মদিন কোন তারিখে?", new String[]{"১৭ মার্চ", "২৬ মার্চ", "৭ মার্চ", "১৫ আগস্ট"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম রাজধানী কোনটি?", new String[]{"ঢাকা", "সোনারগাঁও", "ময়মনসিংহ", "চট্টগ্রাম"}, 1));
        banglaQuestions.add(new Question("বাংলা", "কোনটি বাংলাদেশের বৃহত্তম জেলা?", new String[]{"রাঙামাটি", "চট্টগ্রাম", "সিলেট", "কক্সবাজার"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের পতাকার সবুজ রঙ কী নির্দেশ করে?", new String[]{"সবুজ প্রকৃতি", "মুক্তিযুদ্ধ", "গ্রামের জীবন", "বাংলার তরুণ প্রজন্ম"}, 0));
        banglaQuestions.add(new Question("বাংলা", "জাতীয় কবি কাজী নজরুল ইসলামের জন্মস্থান কোথায়?", new String[]{"কুমিল্লা", "বর্ধমান", "ময়মনসিংহ", "পশ্চিমবঙ্গের চুরুলিয়া"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের মোট বিভাগ কতটি?", new String[]{"৬", "৭", "৮", "৯"}, 2));
        banglaQuestions.add(new Question("বাংলা", "কোন তারিখে বাংলাদেশের স্বাধীনতা দিবস পালন করা হয়?", new String[]{"২৬ মার্চ", "১৬ ডিসেম্বর", "৭ মার্চ", "১৭ মার্চ"}, 0));
        banglaQuestions.add(new Question("বাংলা", "কোনটি বাংলাদেশের সবচেয়ে বড় নদী?", new String[]{"যমুনা", "পদ্মা", "মেঘনা", "কর্ণফুলী"}, 1));
        banglaQuestions.add(new Question("বাংলা", "শহীদ মিনার কোথায় অবস্থিত?", new String[]{"ঢাকা", "খুলনা", "সিলেট", "রাজশাহী"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় ফল কোনটি?", new String[]{"আম", "কাঁঠাল", "লিচু", "পেয়ারা"}, 1));
        banglaQuestions.add(new Question("বাংলা", "মুক্তিযুদ্ধের সময় পাকিস্তানি বাহিনীর আত্মসমর্পণের তারিখ কী?", new String[]{"১৬ ডিসেম্বর", "২৬ মার্চ", "২৫ মার্চ", "১৪ ডিসেম্বর"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম প্রধানমন্ত্রী কে ছিলেন?", new String[]{"তাজউদ্দীন আহমদ", "শেখ মুজিবুর রহমান", "জিয়াউর রহমান", "আব্দুল হামিদ"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশে সবচেয়ে উঁচু পাহাড় কোনটি?", new String[]{"কেওক্রাডাং", "তাজিংডং", "সাকা হাফং", "রুমা"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় স্মৃতিসৌধ কোথায় অবস্থিত?", new String[]{"সাভার", "গোপালগঞ্জ", "নরসিংদী", "রাঙামাটি"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম প্রেসিডেন্ট কে ছিলেন?", new String[]{"শেখ মুজিবুর রহমান", "তাজউদ্দীন আহমদ", "জিয়াউর রহমান", "ইয়াহিয়া খান"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের স্বাধীনতার ঘোষণাপত্র কোথায় স্বাক্ষরিত হয়?", new String[]{"ঢাকা", "মুজিবনগর", "চট্টগ্রাম", "খুলনা"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশে আদি ইতিহাসের সময়কাল কোনটি?", new String[]{"পলাশী যুদ্ধ", "মহাস্থানগড়", "মুঘল আমল", "স্বাধীনতা যুদ্ধ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সর্বোচ্চ আদালত কোথায়?", new String[]{"ঢাকা", "চট্টগ্রাম", "খুলনা", "রাজশাহী"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় মাছ কী?", new String[]{"কাতলা", "ইলিশ", "পাঙ্গাস", "চিংড়ি"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের স্বাধীনতা দিবস কোন তারিখে?", new String[]{"২৬ মার্চ", "২১ ফেব্রুয়ারি", "১৬ ডিসেম্বর", "১৫ আগস্ট"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় সংগীত কে লিখেছেন?", new String[]{"কাজী নজরুল ইসলাম", "রবীন্দ্রনাথ ঠাকুর", "জীবনানন্দ দাশ", "সুকান্ত ভট্টাচার্য"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম রাষ্ট্রপতি কে ছিলেন?", new String[]{"শেখ মুজিবুর রহমান", "জিয়াউর রহমান", "তাজউদ্দীন আহমদ", "খন্দকার মোশতাক আহমদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় ফুল কোনটি?", new String[]{"গোলাপ", "শাপলা", "সুভাসিনী", "রজনীগন্ধা"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলা ভাষা কত সালে রাষ্ট্রভাষার মর্যাদা পায়?", new String[]{"১৯৪৭", "১৯৫২", "১৯৭১", "১৯৫৬"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় পশু কোনটি?", new String[]{"বাঘ", "হরিণ", "মহিষ", "গরু"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের রাজধানী কোথায়?", new String[]{"ঢাকা", "চট্টগ্রাম", "খুলনা", "রাজশাহী"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশে কয়টি বিভাগ রয়েছে?", new String[]{"৬", "৭", "৮", "৯"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় পাখি কোনটি?", new String[]{"ময়ূর", "দোয়েল", "শালিক", "টিয়া"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম প্রধানমন্ত্রীর নাম কী?", new String[]{"তাজউদ্দীন আহমদ", "শেখ মুজিবুর রহমান", "জিয়াউর রহমান", "খন্দকার মোশতাক আহমদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে বড় নদী কোনটি?", new String[]{"যমুনা", "মেঘনা", "গঙ্গা", "পদ্মা"}, 4));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় বৃক্ষ কোনটি?", new String[]{"আম গাছ", "নারকেল গাছ", "বট গাছ", "কাঁঠাল গাছ"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় ফল কোনটি?", new String[]{"আম", "কাঁঠাল", "লিচু", "পেয়ারা"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে বড় জেলা কোনটি?", new String[]{"রাঙামাটি", "চট্টগ্রাম", "খুলনা", "সিলেট"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে ছোট জেলা কোনটি?", new String[]{"গাজীপুর", "নরসিংদী", "মৌলভীবাজার", "নারায়ণগঞ্জ"}, 4));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় কবি কে?", new String[]{"রবীন্দ্রনাথ ঠাকুর", "কাজী নজরুল ইসলাম", "জীবনানন্দ দাশ", "সুকান্ত ভট্টাচার্য"}, 2));
        banglaQuestions.add(new Question("বাংলা", "১৯৭১ সালে মুক্তিযুদ্ধ কতদিন স্থায়ী হয়েছিল?", new String[]{"৯ মাস", "৬ মাস", "১ বছর", "১০ মাস"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশে প্রথম বিশ্ববিদ্যালয় কোনটি প্রতিষ্ঠিত হয়?", new String[]{"ঢাকা বিশ্ববিদ্যালয়", "রাজশাহী বিশ্ববিদ্যালয়", "চট্টগ্রাম বিশ্ববিদ্যালয়", "জাহাঙ্গীরনগর বিশ্ববিদ্যালয়"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের পতাকায় কি রং রয়েছে?", new String[]{"সবুজ ও লাল", "নীল ও লাল", "সবুজ ও সাদা", "সবুজ ও হলুদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশে সবচেয়ে বড় সমুদ্র সৈকত কোনটি?", new String[]{"কক্সবাজার", "সেন্ট মার্টিন", "পটুয়াখালী", "কুয়াকাটা"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় মসজিদ কোনটি?", new String[]{"বায়তুল মোকাররম", "শাহজালাল মসজিদ", "চাঁদ মসজিদ", "সাতগম্বুজ মসজিদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম মুদ্রা কবে চালু হয়?", new String[]{"১৯৭২", "১৯৭১", "১৯৭৩", "১৯৭৫"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বিখ্যাত ‘মহাস্থানগড়’ কোথায় অবস্থিত?", new String[]{"বগুড়া", "রংপুর", "রাজশাহী", "সিলেট"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সংসদের নাম কি?", new String[]{"জাতীয় সংসদ", "লোকসভা", "পাবলিক অ্যাসেম্বলি", "জাতীয় পরিষদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "মহাকাশে পাঠানো বাংলাদেশের স্যাটেলাইটটির নাম কী?", new String[]{"বঙ্গবন্ধু স্যাটেলাইট-১", "বাংলা স্যাটেলাইট-২", "গাজী স্যাটেলাইট", "মুজিব স্যাটেলাইট"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে বড় জেলা কোনটি?", new String[]{"কক্সবাজার", "চট্টগ্রাম", "রাঙ্গামাটি", "সিলেট"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় সংগীতের প্রথম লাইন কী?", new String[]{"আমার সোনার বাংলা", "আমরা সবাই রাজা", "সাবাস বাংলাদেশ", "জয় বাংলা"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় পাখি কোনটি?", new String[]{"ময়না", "কাক", "দোয়েল", "শালিক"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম প্রেসিডেন্ট কে ছিলেন?", new String[]{"বঙ্গবন্ধু শেখ মুজিবুর রহমান", "তাজউদ্দীন আহমদ", "জিয়াউর রহমান", "খন্দকার মোশতাক আহমদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় বৃক্ষ কোনটি?", new String[]{"কাঁঠাল", "মেহগনি", "আম", "বটগাছ"}, 4));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের মোট জেলা কতটি?", new String[]{"৬০", "৬৪", "৭০", "৭৫"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় কবি কে?", new String[]{"রবীন্দ্রনাথ ঠাকুর", "জসিমউদ্দীন", "কাজী নজরুল ইসলাম", "সুকান্ত ভট্টাচার্য"}, 3));
        banglaQuestions.add(new Question("বাংলা", "কোন বছর বাংলাদেশ স্বাধীন হয়?", new String[]{"১৯৭০", "১৯৭১", "১৯৭২", "১৯৭৩"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে দীর্ঘ নদী কোনটি?", new String[]{"পদ্মা", "মেঘনা", "যমুনা", "ব্রহ্মপুত্র"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় ক্রীড়া কোনটি?", new String[]{"ক্রিকেট", "কাবাডি", "ফুটবল", "হকি"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রথম মহিলা প্রধানমন্ত্রী কে?", new String[]{"সুচিত্রা সেন", "শেখ হাসিনা", "খালেদা জিয়া", "রোকেয়া সাখাওয়াত হোসেন"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় মসজিদ কোনটি?", new String[]{"বায়তুল মোকাররম", "লালবাগ কেল্লা", "আহসান মঞ্জিল", "শাহজালাল মসজিদ"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের সবচেয়ে বড় সমুদ্র সৈকত কোনটি?", new String[]{"কুয়াকাটা", "সন্দ্বীপ", "কক্সবাজার", "সেন্টমার্টিন"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের পতাকায় লাল বৃত্তের অর্থ কী?", new String[]{"সূর্য", "বীর শহীদের রক্ত", "দেশের সুখ", "স্বাধীনতার প্রতীক"}, 2));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের স্বাধীনতা যুদ্ধ কত দিন স্থায়ী হয়েছিল?", new String[]{"৯ মাস", "১ বছর", "৬ মাস", "৩ মাস"}, 1));


        // ইংরেজি প্রশ্ন
//        englishQuestions.add(new Question("ইংরেজি", "Who is known as the father of Computer Science?", new String[]{"Alan Turing", "Charles Babbage", "John Von Neumann", "Ada Lovelace"}, 1));
//        englishQuestions.add(new Question("ইংরেজি", "What is the largest planet in our solar system?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));

        // Randomize and Select
        Collections.shuffle(banglaQuestions);
       // Collections.shuffle(englishQuestions);

        finalQuestions.addAll(banglaQuestions.subList(0, 10)); // 25 Bangla questions
      //  finalQuestions.addAll(englishQuestions.subList(0, 2)); // 2 English questions

        return finalQuestions;
    }
}
