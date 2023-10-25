import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";
import { itemCategory } from "../../constant";

import "./Categories.css";

const Categories = () => {
  const navigate = useNavigate();
  return (
    <section className="category">
      <div className="category-header">
        <h2> Categories </h2>
        <Button variant="outlined" onClick={() => navigate("listCategory")}>
          Show More &gt;&gt;
        </Button>
      </div>

      <div className="category-list">
        {itemCategory.slice(0, 5).map((item) => (
          <Card sx={{ width: 250 }} key={item.alt}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="140"
                image={item.src}
                alt="green iguana"
              />
              <CardContent>
                <Typography variant="h5" component="div" textAlign="center">
                  {item.title}
                </Typography>
              </CardContent>
            </CardActionArea>
          </Card>
        ))}
      </div>
    </section>
  );
};

export default Categories;
