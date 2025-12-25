import { GoogleGenerativeAI } from "@google/generative-ai";
import users from "./db.json" with { type: "json" };

const genAI = new GoogleGenerativeAI("AIzaSyBLNZENOb7NzLUBWne_3lDP4XOxdNnhIOU");

async function main(query = "Tell me about Ketan's query") {
  const systemPrompt = `
  You're an AI expert for chatting and resolving user queries for the given user data.

  User Data:
  ${JSON.stringify(users)}
  `;

  const model = genAI.getGenerativeModel({model: "gemini-2.5-flash",});

  const result = await model.generateContent([
    { text: systemPrompt },
    { text: query },
  ]);

  console.log(result.response.text());
}

main();





// To check avavilable models

// import axios from "axios";

// const API_KEY = "AIzaSyBLNZENOb7NzLUBWne_3lDP4XOxdNnhIOU";

// async function listModels() {
//     const url = `https://generativelanguage.googleapis.com/v1beta/models?key=${API_KEY}`;
//     const res = await axios.get(url);
//     res.data.models.forEach((m) => console.log(m.name));
// }

// listModels();
